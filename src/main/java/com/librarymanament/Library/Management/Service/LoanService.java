package com.librarymanament.Library.Management.Service;

import com.librarymanament.Library.Management.Entity.Loan;
import com.librarymanament.Library.Management.dto.LoanResponse;
import com.librarymanament.Library.Management.dto.NewLoanRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoanService {
    LoanResponse create(NewLoanRequest newLoanRequest);
    List<LoanResponse> getAllLoan();
    void returnBook(String id);
}
