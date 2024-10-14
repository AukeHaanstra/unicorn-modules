package nl.pancompany.unicorn.testcommon.testadapters.persistence;

import nl.pancompany.unicorn.application.domain.model.UnicornId;
import nl.pancompany.unicorn.application.unicorn.domain.model.Leg;
import nl.pancompany.unicorn.application.unicorn.domain.model.Unicorn;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UnicornDtoMapper {

    UnicornDtoMapper INSTANCE = getMapper(UnicornDtoMapper.class);

    Unicorn map(UnicornData unicornData);

    UnicornData map(Unicorn unicorn);

    record UnicornData(UnicornId unicornId, String name, Set<Leg> legs) {
    }

}
