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
@Table(name="Employee_KPI")
public class Empl_KPI {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idEmployeeKpi;

    @ManyToOne
    @JoinColumn(name = "idEmployee")
    private EmployeeTest employee;

    @ManyToOne
    @JoinColumn(name = "idKpi", nullable = false)
    private KPI kpi;

    @Column(name = "recordedDate", nullable = false)
    private String recordedDate;

    @Column(name = "value", precision = 10, scale = 2, nullable = false)
    private BigDecimal value;

    @Column(name = "statusEmployeeKpi", columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean statusEmployeeKpi;

}
