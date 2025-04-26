package api.cibertec.employee.performance.controller;

import api.cibertec.employee.performance.controller.dto.KpiDTO;
import api.cibertec.employee.performance.mapper.KpiMapper;
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

    @Autowired
    private KpiMapper kpiMapper;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findKpiById(@PathVariable long id) {
        Optional<Kpi> kpiOptional = kpiService.findById(id);

        if (kpiOptional.isPresent()) {
            KpiDTO kpiDTO = kpiMapper.toDTO(kpiOptional.get());
            return ResponseEntity.ok(kpiDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<KpiDTO>> listActiveKpi() {
        List<Kpi> activeKpi = kpiService.findKpiActive();

        if (activeKpi.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<KpiDTO> kpiDTO_active = activeKpi.stream()
                .map(kpiMapper::toDTO).
                collect(Collectors.toList());

        return ResponseEntity.ok(kpiDTO_active);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        List<Kpi> kpis = kpiService.findAll();

        if (kpis.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<KpiDTO> kpiDTOs = kpis.stream()
                .map(kpiMapper :: toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(kpiDTOs);


    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody KpiDTO kpiDTO){

        if(kpiDTO.getName().isBlank() || kpiDTO.getDescription().isBlank()) {
            return ResponseEntity.badRequest().build();
        }

        Kpi kpi = kpiMapper.toEntity(kpiDTO);
        kpiService.save(kpi);

        try{
            return ResponseEntity.created(new URI("/api/kpi/save")).build();
        }
        catch (URISyntaxException e){
            return ResponseEntity.internalServerError().body("Error al crear la URI.");
        }
    }
}
