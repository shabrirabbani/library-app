package com.librarymanament.Library.Management.Controller;

import com.librarymanament.Library.Management.Entity.Loan;
import com.librarymanament.Library.Management.Service.LoanService;
import com.librarymanament.Library.Management.constant.APIUrl;
import com.librarymanament.Library.Management.dto.LoanResponse;
import com.librarymanament.Library.Management.dto.NewLoanRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = APIUrl.LOAN)
public class LoanController {

    private final LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanResponse> createLoan(@RequestBody NewLoanRequest newLoanRequest) {
        LoanResponse loanResponse = loanService.create(newLoanRequest);
        if (loanResponse != null) {
            return ResponseEntity.ok(loanResponse);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public List<LoanResponse> getAllLoans() {
        return loanService.getAllLoan();
    }

    @DeleteMapping(path = APIUrl.PATH_VAR_ID)
    public ResponseEntity<Void> returnBook(@PathVariable String id) {
        loanService.returnBook(id);
        return ResponseEntity.noContent().build();
    }
}
