package myFinances.apiFinaces.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "costs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Custo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private BigDecimal value;

    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime lastUpdate;

    @Enumerated(EnumType.STRING)
    private Categoria category;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario usuario;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        lastUpdate = LocalDateTime.now();
    }

}
