package api.cibertec.employee.performance.repository;

import api.cibertec.employee.performance.model.Achievements;
import api.cibertec.employee.performance.model.Kpi;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Kpi_Repository extends JpaRepository<Kpi, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Kpi k SET k.statusKpi = FALSE WHERE k.idKpi= :id")
    void logicDelete(@Param("id") Long id);

    @Query("SELECT k FROM Kpi k WHERE k.statusKpi = TRUE ")
    List<Kpi> findKpiActive();
}
