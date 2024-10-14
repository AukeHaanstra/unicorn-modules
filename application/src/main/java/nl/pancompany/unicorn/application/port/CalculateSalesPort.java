package nl.pancompany.unicorn.application.port;

import nl.pancompany.unicorn.application.domain.model.UnicornId;

public interface CalculateSalesPort {

    SalesDto calculateTotalSales(UnicornId unicornId);

    record SalesDto(UnicornId unicornId, long salesTotal) {
    }

}
