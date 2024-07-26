package com.ram0973.booknetwork.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record BookRequest(
        Integer id,
        @NotBlank(message = "100")
        String title,
        @NotBlank(message = "101")
        String authorName,
        @NotBlank(message = "102")
        String isbn,
        @NotBlank(message = "103")
        String synopsis,
        boolean shareable
) {
}
