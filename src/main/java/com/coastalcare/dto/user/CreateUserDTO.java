package com.coastalcare.dto.user;

import com.coastalcare.models.enums.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateUserDTO(

        @NotBlank(message = "Nome não pode ser vazio")
        @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
        String name,

        @NotBlank(message = "Email não pode ser vazio")
        @Size(max = 100, message = "Email deve ter no máximo 100 caracteres")
        String email,

        @NotNull(message = "Tipo de usuário não pode ser vazio")
        UserType type,

        @NotBlank(message = "Senha não pode ser vazia")
        @Size(max = 100, message = "Senha deve ter no máximo 100 caracteres")
        String password,

        @NotBlank(message = "Confirmação de senha não pode ser vazia")
        @Size(max = 100, message = "Confirmação de senha deve ter no máximo 100 caracteres")
        String passwordConfirmation
) {
}
