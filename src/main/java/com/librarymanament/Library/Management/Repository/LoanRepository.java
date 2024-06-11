package com.librarymanament.Library.Management.Repository;

import com.librarymanament.Library.Management.Entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, String> {
}
