package pruebaAPI.Desempenno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebaAPI.Desempenno.model.Feedback;

@Repository
public interface Feedback_Repository extends JpaRepository<Feedback, Long> {
}
