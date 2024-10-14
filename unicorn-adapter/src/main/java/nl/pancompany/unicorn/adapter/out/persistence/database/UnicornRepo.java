package nl.pancompany.unicorn.adapter.out.persistence.database;

import nl.pancompany.unicorn.adapter.out.persistence.database.model.UnicornJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnicornRepo extends JpaRepository<UnicornJpaEntity, Long> {
}
