package com.arruda.uolhost.rest.api.dtos;

import com.arruda.uolhost.enums.GroupType;
import jakarta.validation.constraints.NotBlank;

public record PlayerDto(@NotBlank String name,
                        @NotBlank String email,
                        String phoneNumber,
                        String codiName,
                        GroupType groupType) {
}
