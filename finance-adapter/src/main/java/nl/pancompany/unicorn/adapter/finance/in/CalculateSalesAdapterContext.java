package nl.pancompany.unicorn.adapter.finance.in;

import lombok.Getter;
import nl.pancompany.unicorn.application.finance.port.in.CalculateTotalSalesUsecase;

@Getter
public class CalculateSalesAdapterContext {

    private final CalculateSalesAdapter calculateSalesAdapter;

    public CalculateSalesAdapterContext(CalculateTotalSalesUsecase calculateTotalSalesUsecase) {
        this.calculateSalesAdapter = new CalculateSalesAdapter(calculateTotalSalesUsecase, TotalSalesDtoMapper.INSTANCE);
    }
}
