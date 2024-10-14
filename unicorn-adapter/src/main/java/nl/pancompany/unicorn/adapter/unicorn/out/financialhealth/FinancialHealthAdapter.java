package nl.pancompany.unicorn.adapter.unicorn.out.financialhealth;

import lombok.RequiredArgsConstructor;
import nl.pancompany.unicorn.application.domain.model.UnicornId;
import nl.pancompany.unicorn.application.port.CalculateSalesPort;
import nl.pancompany.unicorn.application.unicorn.port.out.GetFinancialHealthPort;

@RequiredArgsConstructor
class FinancialHealthAdapter implements GetFinancialHealthPort {

    private final CalculateSalesPort calculateSalesPort;
    private final FinancialHealthMapper mapper;

    public FinancialHealthDto getFinancialHealth(UnicornId unicornId) {
        CalculateSalesPort.SalesDto salesDto = calculateSalesPort.calculateTotalSales(unicornId);
        return mapper.toFinancialHealthDto(salesDto);
    }
}