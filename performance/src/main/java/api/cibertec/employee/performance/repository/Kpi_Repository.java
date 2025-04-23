package api.cibertec.employee.performance.repository;

import api.cibertec.employee.performance.model.Kpi;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Kpi_Repository extends JpaRepository<Kpi, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Kpi k SET k.statusKpi = 0 WHERE k.idKpi= :id")
    void eliminadoLogico(@Param("id") Long id);
}
