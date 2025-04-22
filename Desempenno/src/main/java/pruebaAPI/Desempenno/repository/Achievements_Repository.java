package pruebaAPI.Desempenno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebaAPI.Desempenno.model.Achievements;

import java.util.List;

@Repository
public interface Achievements_Repository extends JpaRepository<Achievements, Long> {

    List<Achievements> findByEmployeeId(long employeeId);
}
