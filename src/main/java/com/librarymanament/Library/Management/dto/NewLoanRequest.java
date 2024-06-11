package com.librarymanament.Library.Management.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NewLoanRequest {
    private String userId;
    private String bookId;
}
