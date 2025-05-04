package api.cibertec.employee.performance.mapper;

import api.cibertec.employee.performance.dto.FeedbackDTO;
import api.cibertec.employee.performance.model.Feedback;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMapper {

    public FeedbackDTO toDTO(Feedback feedback) {
        return FeedbackDTO.builder()
                .idFeedback(feedback.getIdFeedback())
                .idEmployee(feedback.getIdEmployee())
                .date(feedback.getDate())
                .feedbackBy(feedback.getFeedbackBy())
                .type(feedback.getType())
                .content(feedback.getContent())
                .statusFeedback(feedback.isStatusFeedback())
                .build();
    }

    public Feedback toEntity(FeedbackDTO feedbackDTO) {
        return Feedback.builder()
                .idFeedback(feedbackDTO.getIdFeedback())
                .idEmployee(feedbackDTO.getIdEmployee())
                .date(feedbackDTO.getDate())
                .feedbackBy(feedbackDTO.getFeedbackBy())
                .type(feedbackDTO.getType())
                .content(feedbackDTO.getContent())
                .statusFeedback(feedbackDTO.isStatusFeedback())
                .build();
    }
}