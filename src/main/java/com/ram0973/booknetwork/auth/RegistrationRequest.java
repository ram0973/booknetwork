package com.ram0973.booknetwork.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record RegistrationRequest(
        @NotBlank(message = "Firstname is mandatory")
        String firstname,
        @NotBlank(message = "Lastname is mandatory")
        String lastname,
        @Email(message = "Email is not well formatted")
        @NotBlank(message = "Email is mandatory")
        String email,
        @NotBlank(message = "Password is mandatory")
        @Size(min = 8, message = "Password should be 8 characters long minimum")
        String password
) {
}
