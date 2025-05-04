package api.cibertec.employee.performance.repository;

import api.cibertec.employee.performance.model.Achievements;
import api.cibertec.employee.performance.model.Feedback;
import api.cibertec.employee.performance.model.Kpi;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Feedback_Repository extends JpaRepository<Feedback, Long> {

    @Query("SELECT f FROM Feedback f WHERE f.idEmployee = :id")
    List<Feedback> findFeedbackByEmployeeId(@Param("id")Long id);

}
