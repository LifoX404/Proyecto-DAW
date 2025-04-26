package api.cibertec.employee.performance.controller;

import api.cibertec.employee.performance.controller.dto.EmployeeDTO;
import api.cibertec.employee.performance.service.Impl.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        try {
            return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
