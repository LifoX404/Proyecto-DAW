package api.cibertec.employee.performance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KpiDTO
{

    private Long idKpi;

    private String name;

    private String description;

    private String category;

    private String unit;

    private BigDecimal unitValue;

    private Boolean statusKpi;
}
