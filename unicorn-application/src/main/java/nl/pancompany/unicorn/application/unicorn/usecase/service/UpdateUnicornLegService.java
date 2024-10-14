package nl.pancompany.unicorn.application.unicorn.usecase.service;

import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.pancompany.unicorn.application.unicorn.domain.model.Leg;
import nl.pancompany.unicorn.application.unicorn.domain.model.Unicorn;
import nl.pancompany.unicorn.application.domain.model.UnicornId;
import nl.pancompany.unicorn.application.unicorn.usecase.exception.UnicornNotFoundException;
import nl.pancompany.unicorn.application.unicorn.usecase.mapper.LegDtoMapper;
import nl.pancompany.unicorn.application.unicorn.port.in.UpdateLegUsecase;
import nl.pancompany.unicorn.common.Dao;

import static nl.pancompany.unicorn.common.ConstraintValidator.validate;

@Slf4j
@RequiredArgsConstructor
public class UpdateUnicornLegService implements UpdateLegUsecase {

    private final Dao<Unicorn, UnicornId> unicornDao;
    private final LegDtoMapper legDtoMapper;

    public Leg.LegDto updateLeg(UpdateLegDto updateLegDto) throws UnicornNotFoundException, ConstraintViolationException {
        validate(updateLegDto);
        Unicorn unicorn = unicornDao.find(updateLegDto.unicornId());
        updateLeg(unicorn, updateLegDto);
        Unicorn updatedUnicorn = unicornDao.update(unicorn);
        log.info("Updated leg of unicorn with id={}", unicorn.getUnicornId().toStringValue());
        return legDtoMapper.map(updatedUnicorn.getLeg(updateLegDto.legPosition()));
    }

    private void updateLeg(Unicorn unicorn, UpdateLegDto updateLegDto) {
        unicorn.setLegColor(updateLegDto.legPosition(), updateLegDto.color());
        unicorn.setLegSize(updateLegDto.legPosition(), updateLegDto.legSize());
    }

}
