package myFinances.apiFinaces.DTOs.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDTO {

    private String name;
    private String email;
    private String password;
}
