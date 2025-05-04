package api.cibertec.employee.performance.dto;

import api.cibertec.employee.performance.model.FeedbackType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDTO {

    private Long idFeedback;

    private Long idEmployee;

    private String date;

    private Long feedbackBy;

    private FeedbackType type;

    private String content;

    private boolean statusFeedback;

}
