package nl.pancompany.unicorn.adapter.persistence;

import nl.pancompany.unicorn.testcommon.testadapters.persistence.InMemoryPersistenceContext;
import org.junit.jupiter.api.BeforeEach;

class InMemoryPersistenceTest extends PersistenceTest {

    @BeforeEach
    public void setup() {
        InMemoryPersistenceContext inMemoryPersistenceContext = new InMemoryPersistenceContext();
        unicornRepositoryPort = inMemoryPersistenceContext.getUnicornRepository();
    }
}
