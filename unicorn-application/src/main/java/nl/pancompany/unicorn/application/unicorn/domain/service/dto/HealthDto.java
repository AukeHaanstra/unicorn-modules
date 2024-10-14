package nl.pancompany.unicorn.application.unicorn.domain.service.dto;

import lombok.Data;
import nl.pancompany.unicorn.application.unicorn.domain.model.Unicorn;
import nl.pancompany.unicorn.application.unicorn.port.out.GetFinancialHealthPort;

@Data
public class HealthDto {

    private Unicorn.PhysicalHealth physicalHealth;
    private GetFinancialHealthPort.FinancialHealthDto.FinancialHealth financialHealth;
}
