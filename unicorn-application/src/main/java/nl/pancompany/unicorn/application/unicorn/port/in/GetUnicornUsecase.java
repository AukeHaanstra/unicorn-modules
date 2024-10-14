package nl.pancompany.unicorn.application.unicorn.port.in;

import nl.pancompany.unicorn.application.unicorn.domain.model.Unicorn;
import nl.pancompany.unicorn.application.domain.model.UnicornId;
import nl.pancompany.unicorn.application.unicorn.usecase.exception.UnicornNotFoundException;

public interface GetUnicornUsecase {

    Unicorn.UnicornDto getUnicorn(UnicornId unicornId) throws UnicornNotFoundException;

}
