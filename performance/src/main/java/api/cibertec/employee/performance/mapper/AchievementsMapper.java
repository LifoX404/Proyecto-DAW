package api.cibertec.employee.performance.mapper;

import api.cibertec.employee.performance.controller.dto.AchievementsDTO;
import api.cibertec.employee.performance.controller.dto.EmployeeDTO;
import api.cibertec.employee.performance.model.Achievements;
import org.springframework.stereotype.Component;

@Component
public class AchievementsMapper {

    public AchievementsDTO toDTO(Achievements achievements){
        return AchievementsDTO.builder()
                .idAchievements(achievements.getIdAchievements())
                .achievementDate(achievements.getAchievementDate())
                .category(achievements.getCategory())
                .description(achievements.getDescription())
                .statusAchievement(achievements.getStatusAchievement())
                .idEmployee(achievements.getIdEmployee())
                .build();

    }

    public Achievements toEntity(AchievementsDTO achievementsDTO){
        return Achievements.builder()
                .idAchievements(achievementsDTO.getIdAchievements())
                .category(achievementsDTO.getCategory())
                .description(achievementsDTO.getDescription())
                .achievementDate(achievementsDTO.getAchievementDate())
                .idEmployee(achievementsDTO.getIdEmployee())
                .statusAchievement(achievementsDTO.getStatusAchievement())
                .build();

    }
}
