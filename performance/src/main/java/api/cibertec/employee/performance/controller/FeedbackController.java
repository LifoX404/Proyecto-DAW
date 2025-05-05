package api.cibertec.employee.performance.controller;

import api.cibertec.employee.performance.client.EmployeeFeignClient;
import api.cibertec.employee.performance.dto.EmployeeDTO;
import api.cibertec.employee.performance.dto.FeedbackDTO;
import api.cibertec.employee.performance.mapper.FeedbackMapper;
import api.cibertec.employee.performance.model.Feedback;
import api.cibertec.employee.performance.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/performance/feedback")
public class FeedbackController {

    @Autowired
    private IFeedbackService feedbackService;

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Autowired
    private EmployeeFeignClient employeeClient;

    @GetMapping({"/findAll","/list"})
    public ResponseEntity<List<FeedbackDTO>> listarFeedback() {
        List<Feedback> allFeedback = feedbackService.findAll();

        if (allFeedback.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<FeedbackDTO> allFeedbackDTO = allFeedback.stream()
                .map(feedbackMapper::toDTO).
                collect(Collectors.toList());

        return ResponseEntity.ok(allFeedbackDTO);
    }

    @GetMapping("/findByEmployeeId/{id}")
    public ResponseEntity<?> findByEmployee(@PathVariable Long id){
        List<Feedback> feedbackOptional = feedbackService.findFeedbackByEmployeeId(id);

        if(feedbackOptional.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        try {
            boolean employee = employeeClient.validateEmployee(id);
            if (!employee){
                return ResponseEntity.badRequest()
                        .body(Collections.singletonMap("error","El empleado no existe"));
            }
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(Collections.singletonMap("error", "No se pudo validar el empleado"));
        }

        List<FeedbackDTO> list = feedbackOptional.stream()
                .map(feedbackMapper::toDTO).
                collect(Collectors.toList());

        return ResponseEntity.ok(list);
    }


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody FeedbackDTO feedbackDTO){

        if (feedbackDTO.getContent().isBlank() ||
                feedbackDTO.getDate().isBlank() ||
                feedbackDTO.getIdEmployee() == null) {
            return ResponseEntity.badRequest()
                    .body(Collections.singletonMap("error", "Todos los campos son obligatorios"));
        }

        System.out.println(feedbackDTO);


        try{
            boolean employee = employeeClient.validateEmployee(feedbackDTO.getIdEmployee());
            boolean feedbackBy = employeeClient.validateEmployee(feedbackDTO.getFeedbackBy());
            System.out.println(employee);
            if (!employee || !feedbackBy){
                return ResponseEntity.badRequest()
                        .body(Collections.singletonMap("error","Uno o dos de los empleados no existen"));
            }
        }catch (Exception e){
            return ResponseEntity.internalServerError()
                    .body(Collections.singletonMap("Error interno","Ha ocurrido una excepción inesperada"));
        }


        if (feedbackDTO.getIdEmployee().equals(feedbackDTO.getFeedbackBy())) {
            return ResponseEntity.badRequest()
                    .body("Un empleado no puede recibir un feedback por el mismo empleado.");
        }

        Feedback feedback = feedbackMapper.toEntity(feedbackDTO);
        feedbackService.save(feedback);

        try {

            return ResponseEntity.created(new URI("/api/feedback/save"))
                    .body(Collections.singletonMap("mensaje", "Se ha registrado exitosamente."));
        }
        catch (URISyntaxException e) {
            System.out.println("Error : "+ e);
            return ResponseEntity.internalServerError()
                    .body(Collections.singletonMap("error", "Ocurrió un error interno al guardar el feedback"));
        }

    }

}
