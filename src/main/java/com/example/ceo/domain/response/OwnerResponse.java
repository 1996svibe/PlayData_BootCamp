package com.example.ceo.domain.response;

import java.util.UUID;

public record OwnerResponse(
        UUID uuid ,
        String name,
        String number
) {
}
