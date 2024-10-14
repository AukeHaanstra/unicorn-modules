package nl.pancompany.unicorn.testcommon;

import lombok.Getter;
import nl.pancompany.unicorn.adapter.finance.in.CalculateSalesAdapterContext;
import nl.pancompany.unicorn.adapter.unicorn.out.financialhealthadapter.FinancialHealthAdapterContext;
import nl.pancompany.unicorn.application.finance.FinanceContext;
import nl.pancompany.unicorn.application.finance.port.in.CalculateTotalSalesUsecase;
import nl.pancompany.unicorn.application.unicorn.UnicornContext;
import nl.pancompany.unicorn.application.unicorn.port.in.GetLegUsecase;
import nl.pancompany.unicorn.application.unicorn.port.in.GetUnicornUsecase;
import nl.pancompany.unicorn.application.unicorn.port.in.UpdateLegUsecase;
import nl.pancompany.unicorn.application.unicorn.port.out.UnicornRepository;
import nl.pancompany.unicorn.testcommon.testadapters.persistence.InMemoryPersistenceContext;

@Getter
public class ApplicationTestContext {

    private final GetUnicornUsecase getUnicornUsecase;
    private final GetLegUsecase getLegUsecase;
    private final UpdateLegUsecase updateLegUsecase;
    private final UnicornRepository unicornRepository;
    private final CalculateTotalSalesUsecase calculateTotalSalesUsecase;

    public ApplicationTestContext() {
        InMemoryPersistenceContext inMemoryPersistenceContext = new InMemoryPersistenceContext();
        this.unicornRepository = inMemoryPersistenceContext.getUnicornRepository();
        FinanceContext financeContext = new FinanceContext();
        this.calculateTotalSalesUsecase = financeContext.getSalesService();
        CalculateSalesAdapterContext calculateSalesAdapterContext = new CalculateSalesAdapterContext(financeContext.getSalesService());
        FinancialHealthAdapterContext financialHealthAdapterContext = new FinancialHealthAdapterContext(calculateSalesAdapterContext.getCalculateSalesAdapter());
        UnicornContext unicornContext = new UnicornContext(unicornRepository, financialHealthAdapterContext.getGetFinancialHealthPort());
        this.getUnicornUsecase = unicornContext.getGetUnicornService();
        this.getLegUsecase = unicornContext.getGetUnicornLegService();
        this.updateLegUsecase = unicornContext.getUpdateUnicornLegService();
    }

}
