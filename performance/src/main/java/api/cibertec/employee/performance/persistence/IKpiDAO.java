package api.cibertec.employee.performance.persistence;


import api.cibertec.employee.performance.model.Kpi;

import java.util.List;
import java.util.Optional;

public interface IKpiDAO {

    public List<Kpi> findAll();

    public Optional<Kpi> findById(Long id);

    public void save(Kpi kpi);

    public void logicDelete(Long id);

    public List<Kpi> findKpiActive();

}
