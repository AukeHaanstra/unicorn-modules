package nl.pancompany.unicorn.application.unicorn.usecase.service;

import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.pancompany.unicorn.application.unicorn.domain.model.Leg;
import nl.pancompany.unicorn.application.unicorn.port.in.GetLegUsecase;
import nl.pancompany.unicorn.common.Dao;
import nl.pancompany.unicorn.application.unicorn.domain.model.Unicorn;
import nl.pancompany.unicorn.application.domain.model.UnicornId;
import nl.pancompany.unicorn.application.unicorn.usecase.exception.UnicornNotFoundException;
import nl.pancompany.unicorn.application.unicorn.usecase.mapper.LegDtoMapper;

import static nl.pancompany.unicorn.common.ConstraintValidator.validate;

@Slf4j
@RequiredArgsConstructor
public class GetUnicornLegService implements GetLegUsecase {

    private final Dao<Unicorn, UnicornId> unicornDao;
    private final LegDtoMapper legDtoMapper;

    public Leg.LegDto getLeg(GetLegUsecase.QueryLegDto queryLegDto) throws UnicornNotFoundException, ConstraintViolationException {
        validate(queryLegDto);
        Unicorn unicorn = unicornDao.find(queryLegDto.unicornId());
        return legDtoMapper.map(unicorn.getLeg(queryLegDto.legPosition()));
    }

}
