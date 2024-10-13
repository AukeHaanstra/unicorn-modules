package nl.pancompany.unicorn.adapter.out.persistence.database;

import nl.pancompany.unicorn.adapter.out.persistence.database.model.UnicornJpaEntity;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = {UnicornJpaEntity.class})
@EnableJpaRepositories(basePackageClasses = { UnicornRepo.class })
public class UnicornRepositoryConfiguration {
}
