package co.odin.senapi.api.user.web;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record CreateUserDto(
        @NotBlank(message = "Name is required!") String name,
        @NotBlank(message = "Gender is required!") String gender,
        String oneSignalId,
        String studentCardId,
        @NotNull(message = "student or not ") Boolean isStudent
) {
}
