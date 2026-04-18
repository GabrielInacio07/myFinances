package myFinances.apiFinaces.Model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "income")
public class Renda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal incomeFixed;

    @Column(nullable = false)
    private BigDecimal freeLance;

    @Column(nullable = false)
    private BigDecimal performance;
}
