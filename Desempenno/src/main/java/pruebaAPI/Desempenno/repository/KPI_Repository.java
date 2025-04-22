package pruebaAPI.Desempenno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pruebaAPI.Desempenno.model.KPI;

@Repository
public interface KPI_Repository extends JpaRepository<KPI, Long> {


}
