package api.cibertec.employee.performance.controller.dto;

import api.cibertec.employee.performance.model.EmployeeTest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
 class AchievementsDTO {

    private Long idAchievements;

    private EmployeeTest idEmployee;

    private String achievementDate;

    private String category;

    private String description;

    private Boolean statusAchievement;
}
