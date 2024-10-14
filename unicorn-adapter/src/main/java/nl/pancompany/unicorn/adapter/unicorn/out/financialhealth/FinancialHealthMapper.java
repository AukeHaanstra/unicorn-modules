package nl.pancompany.unicorn.adapter.unicorn.out.financialhealth;


import nl.pancompany.unicorn.application.port.CalculateSalesPort;
import nl.pancompany.unicorn.application.unicorn.port.out.GetFinancialHealthPort.FinancialHealthDto;
import nl.pancompany.unicorn.application.unicorn.port.out.GetFinancialHealthPort.FinancialHealthDto.FinancialHealth;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import static nl.pancompany.unicorn.application.unicorn.port.out.GetFinancialHealthPort.FinancialHealthDto.FinancialHealth.*;
import static org.mapstruct.ReportingPolicy.ERROR;
import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(unmappedTargetPolicy = ERROR)
interface FinancialHealthMapper {

    FinancialHealthMapper INSTANCE = getMapper(FinancialHealthMapper.class);

    @Mapping(target = "financialHealth", source="salesTotal", qualifiedByName = "calculateFinancialHealth")
    FinancialHealthDto toFinancialHealthDto(CalculateSalesPort.SalesDto salesDto);

    @Named("calculateFinancialHealth")
    default FinancialHealth calculateFinancialHealth(long salesTotal) {
        if (salesTotal >= 100000) {
            return EXCELLENT;
        } else if (salesTotal >= 50000) {
            return GOOD;
        } else if (salesTotal >= 20000) {
            return SUFFICIENT;
        } else if (salesTotal >= 5000) {
            return INSUFFICIENT;
        } else {
            return CRITICAL;
        }
    }
}