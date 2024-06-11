package com.librarymanament.Library.Management.Service.Impl;

import com.librarymanament.Library.Management.Entity.Book;
import com.librarymanament.Library.Management.Entity.Loan;
import com.librarymanament.Library.Management.Entity.User;
import com.librarymanament.Library.Management.Repository.LoanRepository;
import com.librarymanament.Library.Management.Service.BookService;
import com.librarymanament.Library.Management.Service.LoanService;
import com.librarymanament.Library.Management.Service.UserService;
import com.librarymanament.Library.Management.dto.LoanResponse;
import com.librarymanament.Library.Management.dto.NewLoanRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final BookService bookService;
    private final UserService userService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public LoanResponse create(NewLoanRequest newLoanRequest) {
        User user = userService.getUserById(newLoanRequest.getUserId());
        Book book = bookService.getBookById(newLoanRequest.getBookId());

        if (user == null || book == null || book.getIsLoaned()) {
            throw new IllegalArgumentException("User or book not found, or the book is already loaned.");
        }

        book.setIsLoaned(true);
        bookService.update(book);

        Loan loan = Loan.builder()
                .book(book)
                .user(user)
                .build();
        loanRepository.saveAndFlush(loan);

        return LoanResponse.builder()
                .id(loan.getId())
                .userId(user.getId())
                .bookId(book.getId())
                .build();
    }


    @Override
    public List<LoanResponse> getAllLoan() {
        List<Loan> loans = loanRepository.findAll();

        return loans.stream().map(loan -> {
            return LoanResponse.builder()
                    .id(loan.getId())
                    .bookId(loan.getBook().getId())
                    .userId(loan.getUser().getId())
                    .build();
        }).toList();

    }

    @Override
    public void returnBook(String id) {
        Loan loan = loanRepository.findById(id).orElse(null);

        if (loan != null){
            Book book = loan.getBook();
            book.setIsLoaned(false);
            bookService.update(book);
            loanRepository.saveAndFlush(loan);
        }
    }
}
