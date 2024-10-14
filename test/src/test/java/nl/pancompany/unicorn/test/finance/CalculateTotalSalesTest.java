package nl.pancompany.unicorn.test.finance;

import nl.pancompany.unicorn.application.domain.model.UnicornId;
import nl.pancompany.unicorn.application.finance.port.in.CalculateTotalSalesUsecase;
import nl.pancompany.unicorn.testcommon.ApplicationTestContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculateTotalSalesTest {

    CalculateTotalSalesUsecase calculateTotalSalesUsecase;

    @BeforeEach
    void setup() {
        ApplicationTestContext applicationTestContext = new ApplicationTestContext();
        calculateTotalSalesUsecase = applicationTestContext.getCalculateTotalSalesUsecase();
    }

    @Test
    public void calculatesTotalSales() {
        CalculateTotalSalesUsecase.TotalSalesDto totalSalesDto = calculateTotalSalesUsecase.calculateTotalSales(UnicornId.of("ffffffff-ffff-ffff-ffff-ffffffffffff"));

        assertThat(totalSalesDto.salesTotal()).isEqualTo(21000);
    }


}
