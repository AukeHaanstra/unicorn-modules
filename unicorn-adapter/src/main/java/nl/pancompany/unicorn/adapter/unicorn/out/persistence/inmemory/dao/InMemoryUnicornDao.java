package nl.pancompany.unicorn.adapter.unicorn.out.persistence.inmemory.dao;

import lombok.RequiredArgsConstructor;
import nl.pancompany.unicorn.application.unicorn.port.out.UnicornRepositoryPort;
import nl.pancompany.unicorn.application.unicorn.domain.model.Unicorn;
import nl.pancompany.unicorn.application.unicorn.domain.model.UnicornId;
import nl.pancompany.unicorn.application.unicorn.usecase.exception.UnicornAlreadyExistsException;
import nl.pancompany.unicorn.application.unicorn.usecase.exception.UnicornNotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Profile("test")
@RequiredArgsConstructor
public class InMemoryUnicornDao implements UnicornRepositoryPort {

    private final UnicornJpaMapper unicornJpaMapper;

    private final Map<String, Unicorn> inMemoryStore = new HashMap<>();

    @Override
    public Unicorn find(UnicornId unicornId) throws UnicornNotFoundException {
        requireNonNull(unicornId);
        Unicorn foundUnicorn = inMemoryStore.get(unicornId.toStringValue());
        if (foundUnicorn == null) {
            throw new UnicornNotFoundException();
        }
        return safeCopy(foundUnicorn);
    }

    @Override
    public Unicorn add(Unicorn unicorn) {
        requireNonNull(unicorn);
        String unicornId = unicorn.getUnicornId().toStringValue();
        if (inMemoryStore.containsKey(unicornId)) {
            throw new UnicornAlreadyExistsException();
        } else {
            inMemoryStore.put(unicornId, unicorn);
        }
        inMemoryStore.put(unicornId, unicorn);
        return safeCopy(unicorn);
    }

    @Override
    public Unicorn update(Unicorn unicorn) {
        requireNonNull(unicorn);
        String unicornId = unicorn.getUnicornId().toStringValue();
        if (inMemoryStore.containsKey(unicornId)) {
            inMemoryStore.put(unicornId, unicorn);
        } else {
            throw new UnicornNotFoundException();
        }
        return safeCopy(unicorn);
    }

    @Override
    public long count() {
        return inMemoryStore.size();
    }

    public void clear() {
        inMemoryStore.clear();
    }

    private Unicorn safeCopy(Unicorn source) {
        return unicornJpaMapper.map(unicornJpaMapper.map(source));
    }

    private static void requireNonNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("null");
        }
    }
}
