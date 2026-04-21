package myFinances.apiFinaces.Controller;

import lombok.RequiredArgsConstructor;
import myFinances.apiFinaces.DTOs.User.UserDTO;
import myFinances.apiFinaces.DTOs.User.UserResponseDTO;
import myFinances.apiFinaces.DTOs.User.UserUpdateDTO;
import myFinances.apiFinaces.Model.Usuario;
import myFinances.apiFinaces.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<Void> salvarUser(@RequestBody UserDTO dto){
        service.saveUser(dto);

        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> consultUser(@PathVariable Long id){
        Usuario user = service.consultUser(id);

        UserResponseDTO dto = UserResponseDTO.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();

        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> consultAllUser(){
        List<Usuario> users = service.consultAllUser();

        List<UserResponseDTO> response = users
                .stream()
                .map(user -> UserResponseDTO
                        .builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .build()
                )
                .toList();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody UserUpdateDTO dto){
        service.updateUser(id,dto);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        service.deleteUser(id);

        return ResponseEntity.noContent().build();
    }
}
