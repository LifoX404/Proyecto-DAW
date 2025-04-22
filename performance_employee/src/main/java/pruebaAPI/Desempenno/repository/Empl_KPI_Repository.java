package pruebaAPI.Desempenno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebaAPI.Desempenno.model.Achievements;

@Repository
public interface Empl_KPI_Repository extends JpaRepository<Achievements, Long> {
}
