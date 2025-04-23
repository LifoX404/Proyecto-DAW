package api.cibertec.employee.performance.persistence.Impl;

import api.cibertec.employee.performance.model.Kpi;
import api.cibertec.employee.performance.persistence.IKpiDAO;

import api.cibertec.employee.performance.repository.Kpi_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class KpiDAOImpl implements IKpiDAO {

    @Autowired
    private Kpi_Repository repository;

    @Override
    public List<Kpi> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Kpi> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Kpi kpi) {
        repository.save(kpi);
    }

    @Override
    public void eliminadoLogico(Long id) {
        repository.eliminadoLogico(id);
    }
}
