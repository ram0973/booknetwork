package com.ram0973.booknetwork.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
public record BorrowedBookResponse (
    Integer id,
    String title,
    String authorName,
    String isbn,
    double rate,
    boolean returned,
    boolean returnApproved
) {
}
