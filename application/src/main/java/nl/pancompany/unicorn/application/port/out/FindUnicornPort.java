package nl.pancompany.unicorn.application.port.out;

import nl.pancompany.unicorn.application.domain.model.Unicorn;

public interface FindUnicornPort {
    Unicorn findUnicorn(Unicorn.UnicornId unicornId);
}
