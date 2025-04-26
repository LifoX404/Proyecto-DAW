package api.cibertec.employee.performance.repository;

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

    @Query("SELECT f FROM Feedback f WHERE f.statusFeedback = TRUE ")
    List<Kpi> findFeedbackActive();

    @Modifying
    @Transactional
    @Query("UPDATE Feedback f SET f.statusFeedback = FALSE WHERE f.idFeedback= :id")
    void logicDelete(@Param("id") Long id);
}
