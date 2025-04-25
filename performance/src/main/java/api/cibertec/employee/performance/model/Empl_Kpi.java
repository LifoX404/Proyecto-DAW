package api.cibertec.employee.performance.model;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="employee_kpi")
public class Empl_Kpi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmployeeKpi;

    @ManyToOne
    @JoinColumn(name = "idEmployee")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="idkpi")
    private Kpi kpi;

    @Column(nullable = false)
    private String recordedDate;

    @Column(name = "statusEmployeeKpi", nullable = false ,columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean statusEmployeeKpi;





}
