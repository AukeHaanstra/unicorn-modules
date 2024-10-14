package nl.pancompany.unicorn.adapter.out.persistence.database;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import nl.pancompany.unicorn.application.domain.model.Unicorn;
import nl.pancompany.unicorn.application.port.out.FindUnicornPort;
import nl.pancompany.unicorn.application.port.out.SaveUnicornPort;
import nl.pancompany.unicorn.adapter.out.persistence.database.model.UnicornJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UnicornPersistenceAdapter implements FindUnicornPort, SaveUnicornPort {

    private final UnicornRepo unicornRepo;
    private final UnicornJpaMapper mapper;

    @Override
    public Unicorn findUnicorn(Unicorn.UnicornId unicornId) {
        UnicornJpaEntity unicorn = unicornRepo.findById(unicornId.value()).orElseThrow(EntityNotFoundException::new);
        return mapper.map(unicorn);
    }

    @Override
    public void save(Unicorn unicorn) {
        unicornRepo.save(mapper.map(unicorn));
    }

}
