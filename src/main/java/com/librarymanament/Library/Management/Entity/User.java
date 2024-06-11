package com.librarymanament.Library.Management.Entity;

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
@Table(name = ConstantTable.USER)
public class User {
    @Id
    @GeneratedValue ( strategy = GenerationType.UUID)
    private String id;

    @Column (name = "name")
    private String name;

    @OneToMany (mappedBy = "user")
    @JsonManagedReference
    @JsonIgnore
    private List<Loan> loans;
}
