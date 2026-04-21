package myFinances.apiFinaces.Service;

import lombok.RequiredArgsConstructor;
import myFinances.apiFinaces.DTOs.User.UserDTO;
import myFinances.apiFinaces.DTOs.User.UserUpdateDTO;
import myFinances.apiFinaces.Exception.EmailAlreadyExistsException;
import myFinances.apiFinaces.Exception.EntityNotFound;
import myFinances.apiFinaces.Model.Usuario;
import myFinances.apiFinaces.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private void validateEmailUnique(String email) {
        if (repository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException("E-mail já cadastrado");
        }
    }

    private void validateUser(UserDTO dto) {

        if (dto.getName() == null || dto.getEmail() == null || dto.getPassword() == null) {
            throw new IllegalArgumentException("Nenhum campo pode estar null");
        }

        if (dto.getName().isBlank() || dto.getEmail().isBlank() || dto.getPassword().isBlank()) {
            throw new IllegalArgumentException("Campos não podem estar vazios");
        }

        if (dto.getName().length() < 3) {
            throw new IllegalArgumentException("Nome não pode ter menos que 3 caracteres");
        }

    }

    public void saveUser(UserDTO dto) {
        validateUser(dto);
        validateEmailUnique(dto.getEmail());
        Usuario user = Usuario.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build();
        repository.save(user);
    }

    public Usuario consultUser(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFound("Usuário não encontrado"));
    }

    public List<Usuario> consultAllUser() {
        return repository.findAll();
    }

    public void updateUser(Long id, UserUpdateDTO dto) {

        Usuario user = consultUser(id);

        if (dto.getName() != null) {
            user.setName(dto.getName());
        }

        if (dto.getEmail() != null) {

            if (repository.existsByEmailAndIdNot(dto.getEmail(), id)) {
                throw new EmailAlreadyExistsException("E-mail já cadastrado");
            }

            user.setEmail(dto.getEmail());
        }

        if (dto.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        repository.save(user);
    }


    public void deleteUser(Long id) {
        Usuario user = consultUser(id);
        repository.delete(user);
    }
}
