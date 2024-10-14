package nl.pancompany.unicorn.application.finance.port.in;


import nl.pancompany.unicorn.application.domain.model.UnicornId;

public interface CalculateTotalSalesUsecase {

    TotalSalesDto calculateTotalSales(UnicornId unicornId);

    record TotalSalesDto(UnicornId unicornId, long salesTotal) {
    }
}
