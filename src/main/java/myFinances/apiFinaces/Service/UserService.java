package myFinances.apiFinaces.Service;

import lombok.RequiredArgsConstructor;
import myFinances.apiFinaces.DTOs.User.UserDTO;
import myFinances.apiFinaces.Model.Usuario;
import myFinances.apiFinaces.Repository.UserRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private void validateEmailUnique(String email) {
        if (repository.existsByEmail(email)) {
            throw new DataIntegrityViolationException("E-mail já cadastrado");
        }
    }

    private void validateUser(UserDTO dto){

        if(dto.getName().length() < 3){
            throw new IllegalArgumentException("Nome não pode ser menos que 3 caracter");
        }

        if(dto.getName().isBlank() || dto.getEmail().isBlank() || dto.getPassword().isBlank()){
            throw new IllegalArgumentException("Nenhum campo pode estar null");
        }

    }

    public void saveUser(UserDTO dto){
        validateUser(dto);
        validateEmailUnique(dto.getEmail());
         Usuario user = Usuario.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();

        repository.save(user);
    }
}
