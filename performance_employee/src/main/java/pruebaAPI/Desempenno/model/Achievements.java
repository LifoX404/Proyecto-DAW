package pruebaAPI.Desempenno.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Achievements")
public class Achievements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAchievement;

    @ManyToOne
    @JoinColumn(name = "idEmployee", nullable = false)
    private EmployeeTest employee;

    @Column(name = "achievementDate", nullable = false)
    private String achievementDate;

    @Column(name = "category", length = 50, nullable = false)
    private String category;

    @Column(name = "description", length = 255, nullable = false)
    private String description;

    @Column(name = "statusAchievement", columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean statusAchievement;




}
