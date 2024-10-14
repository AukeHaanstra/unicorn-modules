package nl.pancompany.unicorn.adapter.finance.in;

import nl.pancompany.unicorn.application.finance.port.in.CalculateTotalSalesUsecase;
import nl.pancompany.unicorn.application.port.CalculateSalesPort;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface TotalSalesDtoMapper {

    TotalSalesDtoMapper INSTANCE = getMapper(TotalSalesDtoMapper.class);

    @Mapping(target = "unicornId", source = "unicornId", qualifiedByName = "mapUnicornId")
    CalculateSalesPort.SalesDto map(CalculateTotalSalesUsecase.TotalSalesDto unicornJpaEntity);

}
