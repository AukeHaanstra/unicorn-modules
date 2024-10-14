package nl.pancompany.unicorn.application.unicorn;

import lombok.Getter;
import nl.pancompany.unicorn.application.domain.model.UnicornId;
import nl.pancompany.unicorn.application.unicorn.domain.model.Unicorn;
import nl.pancompany.unicorn.application.unicorn.domain.service.UnicornEnrichmentService;
import nl.pancompany.unicorn.application.unicorn.port.in.GetUnicornUsecase;
import nl.pancompany.unicorn.application.unicorn.port.out.GetFinancialHealthPort;
import nl.pancompany.unicorn.application.unicorn.usecase.mapper.LegDtoMapper;
import nl.pancompany.unicorn.application.unicorn.usecase.mapper.UnicornDtoMapper;
import nl.pancompany.unicorn.application.unicorn.usecase.service.GetUnicornLegService;
import nl.pancompany.unicorn.application.unicorn.usecase.service.GetUnicornService;
import nl.pancompany.unicorn.application.unicorn.usecase.service.UpdateUnicornLegService;
import nl.pancompany.unicorn.common.Repository;

@Getter
public class UnicornContext {

    private final GetUnicornUsecase getUnicornService;
    private final GetUnicornLegService getUnicornLegService;
    private final UpdateUnicornLegService updateUnicornLegService;

    public UnicornContext(Repository<Unicorn, UnicornId> unicornRepository, GetFinancialHealthPort getFinancialHealthPort) {
        this.getUnicornService = createUnicornService(unicornRepository, getFinancialHealthPort);
        this.getUnicornLegService = createGetLegService(unicornRepository);
        this.updateUnicornLegService = createUpdateLegService(unicornRepository);
    }

    private GetUnicornService createUnicornService(Repository<Unicorn, UnicornId> unicornRepository, GetFinancialHealthPort getFinancialHealthPort) {
        UnicornEnrichmentService unicornEnrichmentService = new UnicornEnrichmentService(getFinancialHealthPort,
                UnicornDtoMapper.INSTANCE);
        return new GetUnicornService(unicornRepository, unicornEnrichmentService);
    }

    private GetUnicornLegService createGetLegService(Repository<Unicorn, UnicornId> unicornRepository) {
        return new GetUnicornLegService(unicornRepository, LegDtoMapper.INSTANCE);
    }

    private UpdateUnicornLegService createUpdateLegService(Repository<Unicorn, UnicornId> unicornRepository) {
        return new UpdateUnicornLegService(unicornRepository, LegDtoMapper.INSTANCE);
    }
}
