package nl.pancompany.unicorn.adapter.unicorn.out.financialhealth;

import lombok.Getter;
import nl.pancompany.unicorn.application.port.CalculateSalesPort;
import nl.pancompany.unicorn.application.unicorn.port.out.GetFinancialHealthPort;

@Getter
public class FinancialHealthAdapterContext {

    GetFinancialHealthPort getFinancialHealthPort;

    public FinancialHealthAdapterContext(CalculateSalesPort calculateSalesPort) {
        this.getFinancialHealthPort = new FinancialHealthAdapter(calculateSalesPort, FinancialHealthMapper.INSTANCE);
    }
}
