package com.librarymanament.Library.Management.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.librarymanament.Library.Management.constant.ConstantTable;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = ConstantTable.LOAN)
public class Loan {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference ("userReference")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference ("userReference")
    private Book book;
}
