package nl.pancompany.unicorn.adapter.finance.in;

import lombok.RequiredArgsConstructor;
import nl.pancompany.unicorn.application.domain.model.UnicornId;
import nl.pancompany.unicorn.application.finance.port.in.CalculateTotalSalesUsecase;
import nl.pancompany.unicorn.application.port.CalculateSalesPort;

@RequiredArgsConstructor
public class CalculateSalesAdapter implements CalculateSalesPort {

    private final CalculateTotalSalesUsecase calculateTotalSalesUsecase;
    private final TotalSalesDtoMapper totalSalesDtoMapper;

    @Override
    public SalesDto calculateTotalSales(UnicornId unicornId) {
        return totalSalesDtoMapper.map(calculateTotalSalesUsecase.calculateTotalSales(unicornId));
    }
}
