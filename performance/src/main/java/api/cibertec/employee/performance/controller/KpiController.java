package api.cibertec.employee.performance.controller;

import api.cibertec.employee.performance.controller.dto.KpiDTO;
import api.cibertec.employee.performance.model.Kpi;
import api.cibertec.employee.performance.service.IKpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/kpi")
public class KpiController {

    @Autowired
    private IKpiService kpiService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findKpiById(@PathVariable long id) {
        Optional<Kpi> kpiOptional = kpiService.findById(id);

        if (kpiOptional.isPresent()) {
            Kpi kpi = kpiOptional.get();

            KpiDTO kpiDTO = KpiDTO.builder()
                    .idKpi(kpi.getIdKpi())
                    .name(kpi.getName())
                    .description(kpi.getDescription())
                    .category(kpi.getCategory())
                    .unit(kpi.getUnit())
                    .unitValue(kpi.getUnitValue())
                    .statusKpi(kpi.getStatusKpi())
                    .build();

            return ResponseEntity.ok(kpiDTO);
        }

        return ResponseEntity.notFound().build();
    }
}
