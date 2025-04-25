package api.cibertec.employee.performance.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="achievements")
public class Achievements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAchievements;

    //@ManyToOne
    //@JoinColumn(name = "idEmployee", nullable=false)
    private Long idEmployee;

    @Column(nullable = false)
    private String achievementDate;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String description;

    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    private Boolean statusAchievement;

}
