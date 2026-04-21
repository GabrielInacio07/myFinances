package myFinances.apiFinaces.Repository;

import myFinances.apiFinaces.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Usuario,Long> {

    boolean existsByEmail(String email);
}
