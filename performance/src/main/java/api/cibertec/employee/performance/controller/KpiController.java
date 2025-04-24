package api.cibertec.employee.performance.controller;

import api.cibertec.employee.performance.controller.dto.KpiDTO;
import api.cibertec.employee.performance.model.Kpi;
import api.cibertec.employee.performance.service.IKpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping("/active")
    public ResponseEntity<List<KpiDTO>> listActiveKpi() {
        List<Kpi> activeKpi = kpiService.listKpi();

        if (activeKpi.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<KpiDTO> kpiDtos = activeKpi.stream()
                .map(kpi -> KpiDTO.builder()
                        .idKpi(kpi.getIdKpi())
                        .name(kpi.getName())
                        .description(kpi.getDescription())
                        .category(kpi.getCategory())
                        .unit(kpi.getUnit())
                        .unitValue(kpi.getUnitValue())
                        .statusKpi(kpi.getStatusKpi())
                        .build())
                .collect(Collectors.toList());



        return ResponseEntity.ok(kpiDtos);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        List<KpiDTO> KpiList = kpiService.findAll()
                .stream()
                .map(kpi -> KpiDTO.builder()
                        .idKpi(kpi.getIdKpi())
                        .name(kpi.getName())
                        .description(kpi.getDescription())
                        .category(kpi.getCategory())
                        .unit(kpi.getUnit())
                        .unitValue(kpi.getUnitValue())
                        .statusKpi(kpi.getStatusKpi())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(KpiList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody KpiDTO kpiDTO){



        if(kpiDTO.getName().isBlank() || kpiDTO.getDescription().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        kpiService.save(Kpi.builder()
                .name(kpiDTO.getName())
                .description(kpiDTO.getDescription())
                .category(kpiDTO.getCategory())
                .unit(kpiDTO.getUnit())
                .unitValue(kpiDTO.getUnitValue())
                .statusKpi(kpiDTO.getStatusKpi())
                .build());

        try{
            return ResponseEntity.created(new URI("/api/kpi/save")).build();
        }
        catch (URISyntaxException e){
            return ResponseEntity.internalServerError().body("Error al crear la URI.");
        }
    }
}
