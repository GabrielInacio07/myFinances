package myFinances.apiFinaces.Repository;

import myFinances.apiFinaces.Model.Renda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RendaRepository extends JpaRepository<Renda, Long> {
    List<Renda> findByUsuarioId(Long userId);
}
