package myFinances.apiFinaces.Repository;

import jakarta.persistence.Id;
import myFinances.apiFinaces.Model.Custo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustoRepository extends JpaRepository <Custo, Long> {
}
