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
    private Long idFeedback;

    //@ManyToOne
    //@JoinColumn(name = "idEmployee", nullable = false)
    private Long idEmployee;

    @Column(name = "date", nullable = false)
    private String date;

    //@ManyToOne
    //@JoinColumn(name = "feedbackBy", nullable = false)
    private Long feedbackBy;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, columnDefinition = "VARCHAR(50) DEFAULT 'NO_ESPECIFICADA'")
    private FeedbackType type;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "statusFeedback",columnDefinition = "BOOLEAN DEFAULT TRUE")
    private boolean statusFeedback;

}
