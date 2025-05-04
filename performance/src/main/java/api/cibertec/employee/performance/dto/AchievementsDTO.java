package api.cibertec.employee.performance.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AchievementsDTO {

    private Long idAchievements;

    private Long idEmployee;

    private String achievementDate;

    private String category;

    private String description;

    private Boolean statusAchievement;
}
