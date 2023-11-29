package nl.pancompany.unicorn.application.port.in;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import nl.pancompany.unicorn.application.domain.model.Color;

public interface SetColorUseCase {
    @Transactional
    void colorPart(@Valid SetColorCommand command);

    record SetColorCommand(@NotNull Long unicornId, @NotNull Long partId, @NotNull Color color) {
    }
}
