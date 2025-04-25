package api.cibertec.employee.performance.client;

import api.cibertec.employee.performance.configuration.FeignClientConfig;
import api.cibertec.employee.performance.controller.dto.EmployeeDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@FeignClient(name = "USER-MOCK-API", url = "${external.mock.api.base-url}",configuration = FeignClientConfig.class)
public interface EmployeeFeignClient {

    @GetMapping(value = "/employee", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<EmployeeDTO> getEmployees();
}

