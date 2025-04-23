package api.cibertec.employee.performance.repository;

import api.cibertec.employee.performance.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Feedback_Repository extends JpaRepository<Feedback, Long> {
}
