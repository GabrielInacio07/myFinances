package myFinances.apiFinaces.Repository;

import myFinances.apiFinaces.Model.Renda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RendaRepository extends JpaRepository<Renda, UUID> {
}
