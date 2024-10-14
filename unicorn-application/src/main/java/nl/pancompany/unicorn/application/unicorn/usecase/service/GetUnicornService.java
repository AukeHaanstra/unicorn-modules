package nl.pancompany.unicorn.application.unicorn.usecase.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.pancompany.unicorn.application.unicorn.port.in.GetUnicornUsecase;
import nl.pancompany.unicorn.common.Repository;
import nl.pancompany.unicorn.application.unicorn.domain.model.Unicorn;
import nl.pancompany.unicorn.application.domain.model.UnicornId;
import nl.pancompany.unicorn.application.unicorn.domain.service.UnicornEnrichmentService;
import nl.pancompany.unicorn.application.unicorn.usecase.exception.UnicornNotFoundException;

@Slf4j
@RequiredArgsConstructor
public class GetUnicornService implements GetUnicornUsecase {

    private final Repository<Unicorn, UnicornId> unicornRepository;
    private final UnicornEnrichmentService unicornEnrichmentService;

    @Override
    public Unicorn.UnicornDto getUnicorn(UnicornId unicornId) throws UnicornNotFoundException {
        Unicorn unicorn = unicornRepository.find(unicornId);
        return unicornEnrichmentService.enrich(unicorn);
    }

}
