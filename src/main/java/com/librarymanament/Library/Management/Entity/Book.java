package com.librarymanament.Library.Management.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.librarymanament.Library.Management.constant.ConstantTable;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = ConstantTable.BOOK)
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String id;

    @Column (name = "title")
    private String title;

    @Column (name = "isbn")
    private String isbn;

    @Column (name = "is_loan")
    private Boolean isLoaned;

    @OneToMany(mappedBy = "book")
    @JsonManagedReference
    @JsonIgnore
    private List<Loan> loans;

}
