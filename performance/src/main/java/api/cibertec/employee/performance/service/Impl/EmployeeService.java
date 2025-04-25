package api.cibertec.employee.performance.service.Impl;

import api.cibertec.employee.performance.client.EmployeeFeignClient;
import api.cibertec.employee.performance.controller.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeFeignClient client;

    public List<EmployeeDTO> getAllEmployees() {
        return client.getEmployees();
    }
}
