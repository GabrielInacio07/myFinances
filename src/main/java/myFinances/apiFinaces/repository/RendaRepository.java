package myFinances.apiFinaces.repository;

import myFinances.apiFinaces.model.Renda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RendaRepository extends JpaRepository<Renda, UUID> {
}
