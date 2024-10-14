package nl.pancompany.unicorn.testcommon.testadapters.persistence;

import nl.pancompany.unicorn.application.domain.model.UnicornId;
import nl.pancompany.unicorn.application.unicorn.domain.model.Unicorn;
import org.mapstruct.Mapper;
import org.mapstruct.control.DeepClone;

import static org.mapstruct.factory.Mappers.getMapper;

@Mapper(mappingControl = DeepClone.class)
public interface UnicornCloneMapper {

    UnicornCloneMapper INSTANCE = getMapper(UnicornCloneMapper.class);

    Unicorn map(Unicorn unicornData);

    default UnicornId mapUnicornId(UnicornId unicornId) {
        return UnicornId.of(unicornId.getValue());
    }
}
