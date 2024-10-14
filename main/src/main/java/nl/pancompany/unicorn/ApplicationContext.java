package nl.pancompany.unicorn;

import lombok.Getter;
import nl.pancompany.unicorn.application.domain.model.UnicornId;
import nl.pancompany.unicorn.application.finance.port.in.CalculateTotalSalesUsecase;
import nl.pancompany.unicorn.application.unicorn.port.in.GetLegUsecase;
import nl.pancompany.unicorn.application.unicorn.port.in.GetUnicornUsecase;
import nl.pancompany.unicorn.application.unicorn.port.in.UpdateLegUsecase;
import nl.pancompany.unicorn.common.Repository;
import nl.pancompany.unicorn.application.unicorn.domain.model.Unicorn;
import nl.pancompany.unicorn.adapter.finance.in.CalculateSalesAdapterContext;
import nl.pancompany.unicorn.adapter.unicorn.out.financialhealthadapter.FinancialHealthAdapterContext;
import nl.pancompany.unicorn.application.finance.FinanceContext;
import nl.pancompany.unicorn.application.unicorn.UnicornContext;

@Getter
public class ApplicationContext {

    private final GetUnicornUsecase getUnicornUsecase;
    private final GetLegUsecase getLegUsecase;
    private final UpdateLegUsecase updateLegUsecase;
    private final CalculateTotalSalesUsecase calculateTotalSalesUsecase;

    public ApplicationContext(Repository<Unicorn, UnicornId> unicornRepository) {
        FinanceContext financeContext = new FinanceContext();
        CalculateSalesAdapterContext calculateSalesAdapterContext = new CalculateSalesAdapterContext(financeContext.getSalesService());
        FinancialHealthAdapterContext financialHealthAdapterContext = new FinancialHealthAdapterContext(calculateSalesAdapterContext.getCalculateSalesAdapter());
        UnicornContext unicornContext = new UnicornContext(unicornRepository, financialHealthAdapterContext.getGetFinancialHealthPort());
        this.getUnicornUsecase = unicornContext.getGetUnicornService();
        this.getLegUsecase = unicornContext.getGetUnicornLegService();
        this.updateLegUsecase = unicornContext.getUpdateUnicornLegService();
        this.calculateTotalSalesUsecase = financeContext.getSalesService();
    }
}
