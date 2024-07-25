package com.ram0973.booknetwork.auth;

import lombok.Builder;

@Builder
public record AuthenticationResponse(String token) {
}
