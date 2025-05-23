package api.cibertec.employee.performance.client;


import api.cibertec.employee.performance.dto.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "Employee-service", url = "http://localhost:8082")
public interface EmployeeFeignClient {

    @GetMapping("/api/employees/validateEmployee/{employeeId}")
    boolean validateEmployee(@PathVariable Long employeeId);


}

