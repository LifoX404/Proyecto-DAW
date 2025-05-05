package api.cibertec.employee.performance.controller;

import api.cibertec.employee.performance.client.EmployeeFeignClient;
import api.cibertec.employee.performance.dto.AchievementsDTO;
import api.cibertec.employee.performance.dto.EmployeeDTO;
import api.cibertec.employee.performance.mapper.AchievementsMapper;
import api.cibertec.employee.performance.model.Achievements;
import api.cibertec.employee.performance.service.IAchievementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/performance/achievements")
public class AchievementsController {

    @Autowired
    private IAchievementsService achievementsService;

    @Autowired
    private AchievementsMapper achievementsMapper;

    @Autowired
    private EmployeeFeignClient employeeClient;

    public AchievementsController(){
    }

//    @GetMapping("/testEmployees")
//    public ResponseEntity<List<EmployeeDTO>> listarEmpleados(){
//        List<EmployeeDTO> activeEmployees = employeeClient.listarEmployees();
//
//        if(activeEmployees.isEmpty()){
//            return ResponseEntity.notFound().build();
//        }
//
//        System.out.println("Lista de empleados" + activeEmployees);
//
//        return ResponseEntity.ok(activeEmployees);
//    }

    @GetMapping("/findByEmployee/{id}")
    public ResponseEntity<?> findByEmployee(@PathVariable Long id){
        List<Achievements> achievementsOptional = achievementsService.findAchievementsByEmployeeId(id);

        if(achievementsOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        List<AchievementsDTO> list = achievementsOptional.stream()
                .map(achievementsMapper::toDTO).
                collect(Collectors.toList());

        return ResponseEntity.ok(list);
    }



    @GetMapping("/list")
    public ResponseEntity<List<AchievementsDTO>> listActiveAchievements(){
        List<Achievements> activeAchievements = achievementsService.findAchievementsActive();

        if(activeAchievements.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        List<AchievementsDTO> achievementsDTO_active = activeAchievements.stream()
                .map(achievementsMapper::toDTO).
                collect(Collectors.toList());

        return ResponseEntity.ok(achievementsDTO_active);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<Achievements> achievements = achievementsService.findAll();

        if(achievements.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        List<AchievementsDTO> achievementsDTOs = achievements.stream()
                .map(achievementsMapper::toDTO).
                collect(Collectors.toList());

        return ResponseEntity.ok(achievementsDTOs);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody AchievementsDTO achievementsDTO) {
        if (achievementsDTO.getDescription() == null ||
                achievementsDTO.getCategory() == null ||
                achievementsDTO.getIdEmployee() == null) {
            return ResponseEntity.badRequest()
                    .body(Collections.singletonMap("error", "Todos los campos son obligatorios"));
        }


        System.out.println(achievementsDTO.getIdEmployee());

        if (employeeClient == null) {
            System.out.println("El cliente Feign no está inicializado.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "El cliente no está configurado"));
        }

        try {
            boolean employee = employeeClient.validateEmployee(achievementsDTO.getIdEmployee());
        System.out.println(employee);
            if (!employee) {
                return ResponseEntity.badRequest()
                        .body(Collections.singletonMap("error", "El empleado no existe"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(Collections.singletonMap("error", "No se pudo validar el empleado"));
        }

        Achievements achievements = achievementsMapper.toEntity(achievementsDTO);
        achievementsService.save(achievements);

        try {
            return ResponseEntity.created(new URI("/api/achievements/save"))
                    .body(Collections.singletonMap("mensaje", "El logro se ha registrado exitosamente."));
        } catch (URISyntaxException e) {
            System.out.println("Error : " + e);
            return ResponseEntity.internalServerError()
                    .body(Collections.singletonMap("error", "Ocurrió un error al guardar el logro."));


        }
    }

}
