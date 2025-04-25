package api.cibertec.employee.performance.service;

import api.cibertec.employee.performance.model.Kpi;

import java.util.List;
import java.util.Optional;

public interface IKpiService {

    public List<Kpi> findAll();

    public Optional<Kpi> findById(Long id);

    public void save(Kpi kpi);

    public void logicDelete(Long id);

    public List<Kpi> findKpiActive();

}
