package nl.pancompany.unicorn.application.domain.service;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.pancompany.unicorn.application.domain.model.PartId;
import nl.pancompany.unicorn.application.domain.model.Unicorn;
import nl.pancompany.unicorn.application.port.in.SetColorUseCase;
import nl.pancompany.unicorn.application.port.out.FindUnicornPort;
import nl.pancompany.unicorn.application.port.out.SaveUnicornPort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ColoringService implements SetColorUseCase {

    private final FindUnicornPort findUnicornPort;
    private final SaveUnicornPort saveUnicornPort;

    @Override
    @Transactional
    public void colorPart(@Valid SetColorCommand command) {
        Unicorn unicorn = findUnicornPort.findUnicorn(Unicorn.UnicornId.of(command.unicornId()));
        unicorn.colorPart(PartId.of(command.partId()), command.color());
        saveUnicornPort.save(unicorn);
    }
}
