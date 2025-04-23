package api.cibertec.employee.performance.repository;

import api.cibertec.employee.performance.model.Empl_Kpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Empl_KPI_Repository extends JpaRepository<Empl_Kpi, Long> {

}
