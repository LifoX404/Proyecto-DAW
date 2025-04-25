package api.cibertec.employee.performance.service.Impl;

import api.cibertec.employee.performance.model.Kpi;
import api.cibertec.employee.performance.persistence.IKpiDAO;
import api.cibertec.employee.performance.service.IKpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class KpiServiceImpl  implements IKpiService {

    @Autowired
    private IKpiDAO kpiDAO;


    @Override
    public List<Kpi> findAll() {
        return kpiDAO.findAll();
    }

    @Override
    public Optional<Kpi> findById(Long id) {
        return kpiDAO.findById(id);
    }

    @Override
    public void save(Kpi kpi) {
        kpiDAO.save(kpi);
    }

    @Override
    public void logicDelete(Long id) {
        kpiDAO.logicDelete(id);
    }

    @Override
    public List<Kpi> findKpiActive() {
        return kpiDAO.findKpiActive();
    }


}
