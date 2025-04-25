package api.cibertec.employee.performance.repository;

import api.cibertec.employee.performance.model.Achievements;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Achievements_Repository extends JpaRepository<Achievements, Long> {

    @Query("SELECT a FROM Achievements a WHERE a.idEmployee = :id")
    List<Achievements> findAchievementsByEmployeeId(@Param("id") long id);

    @Modifying
    @Transactional
    @Query("UPDATE Achievements a SET a.statusAchievement=false WHERE a.idAchievements= :id")
    void logicDelete(@Param("id") Long id);

    @Query("SELECT a FROM Achievements a WHERE a.statusAchievement= TRUE")
    List<Achievements> findAchievementsActive();
}
