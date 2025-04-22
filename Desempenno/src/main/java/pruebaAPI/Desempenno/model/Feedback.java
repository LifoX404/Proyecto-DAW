package pruebaAPI.Desempenno.model;

import jakarta.persistence.*;

@Entity
@Table(name="Feedback")
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
    @Column(name = "feedbackType", nullable = false)
    private FeedbackType feedbackType;

    @Column(name = "feedbackContent", columnDefinition = "TEXT")
    private String feedbackContent;
}
