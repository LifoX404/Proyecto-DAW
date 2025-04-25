package api.cibertec.employee.performance.mapper;

import api.cibertec.employee.performance.controller.dto.KpiDTO;
import api.cibertec.employee.performance.model.Kpi;
import org.springframework.stereotype.Component;

@Component
public class KpiMapper {

    public KpiDTO toDTO(Kpi kpi){
        return KpiDTO.builder()
                .idKpi(kpi.getIdKpi())
                .name(kpi.getName())
                .description(kpi.getDescription())
                .category(kpi.getCategory())
                .unit(kpi.getUnit())
                .unitValue(kpi.getUnitValue())
                .statusKpi(kpi.getStatusKpi())
                .build();
    }

    public Kpi toEntity(KpiDTO kpiDTO){
        return  Kpi.builder()
                .idKpi(kpiDTO.getIdKpi())
                .name(kpiDTO.getName())
                .description(kpiDTO.getDescription())
                .category(kpiDTO.getCategory())
                .unit(kpiDTO.getUnit())
                .unitValue(kpiDTO.getUnitValue())
                .statusKpi(kpiDTO.getStatusKpi())
                .build();
    }
}
