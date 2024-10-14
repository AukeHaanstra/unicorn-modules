package nl.pancompany.unicorn.testcommon.testadapters.persistence;

import lombok.Getter;
import nl.pancompany.unicorn.application.unicorn.port.out.UnicornRepository;

@Getter
public class InMemoryPersistenceContext {

    private final UnicornRepository unicornRepository;

    public InMemoryPersistenceContext() {
        this.unicornRepository = new InMemoryUnicornRepository(UnicornCloneMapper.INSTANCE);
    }
}
