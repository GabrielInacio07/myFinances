package myFinances.apiFinaces.DTOs.User;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserUpdateDTO {

    private String name;
    private String email;
    private String password;
}
