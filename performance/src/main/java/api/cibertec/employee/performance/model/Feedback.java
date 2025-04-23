package api.cibertec.employee.performance.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAchievement;

    @ManyToOne
    @JoinColumn(name = "idEmployee", nullable = false)
    private EmployeeTest employee;

    @Column(name = "feedbackDate", nullable = false)
    private String feedbackDate;

    @ManyToOne
    @JoinColumn(name = "feedbackBy", nullable = false)
    private EmployeeTest feedbackGiver;

    @Enumerated(EnumType.STRING)
    @Column(name = "feedbackType", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'NO_ESPECIFICADA'")
    private FeedbackType feedbackType;

    @Column(name = "feedbackContent", columnDefinition = "TEXT")
    private String feedbackContent;

}
