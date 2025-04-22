package pruebaAPI.Desempenno.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="KPI")
public class KPI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idKpi;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "description", length = 150, nullable = false)
    private String description;

    @Column(name = "category", length = 20, nullable = false)
    private String category;

    @Column(name = "unit", length = 20, nullable = false)
    private String unit;

    @Column(name = "unitValue", precision = 10, scale = 2, nullable = false)
    private BigDecimal unitValue;

    @Column(name = "statusKpi", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean statusKpi;

    // Getters and Setters
}
