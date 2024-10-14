package nl.pancompany.unicorn.adapter.out.persistence.database;

import nl.pancompany.unicorn.adapter.out.persistence.database.model.UnicornPartJpaEntity;
import nl.pancompany.unicorn.application.domain.model.Leg;
import nl.pancompany.unicorn.application.domain.model.PartId;
import nl.pancompany.unicorn.application.domain.model.Unicorn;
import nl.pancompany.unicorn.application.domain.model.Unicorn.UnicornId;
import nl.pancompany.unicorn.adapter.out.persistence.database.model.UnicornJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UnicornJpaMapper {
    @Mapping(target="id", source = "id", qualifiedByName = "mapUnicornId")
    @Mapping(target="legs", source = "parts", qualifiedByName = "partToLegMapper")
    Unicorn map(UnicornJpaEntity unicornJpaEntity);

    @Named("mapUnicornId")
    default UnicornId mapUnicornId(Long value) {
        return UnicornId.of(value);
    }

    @Named("partToLegMapper")
    @Mapping(target="id", source = "id", qualifiedByName = "mapPartId")
    Leg map(UnicornPartJpaEntity unicornPartJpaEntity);

    @Named("mapPartId")
    default PartId mapPartId(Long value) {
        return PartId.of(value);
    }

    @Mapping(target="parts", source = "legs", qualifiedByName = "legToPartMapper")
    UnicornJpaEntity map(Unicorn unicorn);

    @Named("legToPartMapper")
    @Mapping(target="id", source = "id")
    @Mapping(target = "unicorn", ignore = true)
    UnicornPartJpaEntity map(Leg unicornPartJpaEntity);

    default Long map(Unicorn.UnicornId unicornId) {
        return unicornId.value();
    }

    default Long map(PartId partId) {
        return partId.value();
    }
}
