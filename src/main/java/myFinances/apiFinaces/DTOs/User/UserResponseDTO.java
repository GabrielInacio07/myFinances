package myFinances.apiFinaces.DTOs.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class UserResponseDTO {
    private String name;
    private String email;
}
