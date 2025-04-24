package api.cibertec.employee.performance.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "kpi")
public class Kpi {

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

    @Column(name = "statusKpi", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean statusKpi;

}
