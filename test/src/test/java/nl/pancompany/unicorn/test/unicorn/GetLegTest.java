package nl.pancompany.unicorn.test.unicorn;

import jakarta.validation.ConstraintViolationException;
import nl.pancompany.unicorn.application.domain.model.UnicornId;
import nl.pancompany.unicorn.application.unicorn.port.in.GetLegUsecase;
import nl.pancompany.unicorn.application.unicorn.domain.model.Color;
import nl.pancompany.unicorn.application.unicorn.domain.model.Leg;
import nl.pancompany.unicorn.application.unicorn.domain.model.Unicorn;
import nl.pancompany.unicorn.application.unicorn.port.out.UnicornRepository;
import nl.pancompany.unicorn.application.unicorn.usecase.exception.UnicornNotFoundException;
import nl.pancompany.unicorn.testcommon.ApplicationTestContext;
import nl.pancompany.unicorn.testcommon.testbuilders.LegTestBuilder;
import nl.pancompany.unicorn.testcommon.testbuilders.UnicornTestBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GetLegTest {

    UnicornRepository unicornRepositoryPort;
    GetLegUsecase getLegUsecase;
    Unicorn savedUnicorn;

    @BeforeEach
    void setup() {
        ApplicationTestContext applicationTestContext = new ApplicationTestContext();
        unicornRepositoryPort = applicationTestContext.getUnicornRepository();
        getLegUsecase = applicationTestContext.getGetLegUsecase();

        Leg newLeg = new LegTestBuilder()
                .legPosition(Leg.LegPosition.FRONT_LEFT)
                .color(Color.GREEN)
                .legSize(Leg.LegSize.SMALL)
                .build();
        savedUnicorn = unicornRepositoryPort.add(new UnicornTestBuilder()
                .defaults()
                .withLeg(newLeg)
                .build());
    }

    @Test
    void findsLeg() {
        var queryLegDto = new GetLegUsecase.QueryLegDto(savedUnicorn.getUnicornId(), Leg.LegPosition.FRONT_LEFT);

        Leg.LegDto legDto = getLegUsecase.getLeg(queryLegDto);

        Assertions.assertThat(legDto.legPosition()).isEqualTo(Leg.LegPosition.FRONT_LEFT);
        Assertions.assertThat(legDto.color()).isEqualTo(Color.GREEN);
        Assertions.assertThat(legDto.legSize()).isEqualTo(Leg.LegSize.SMALL);
    }

    @Test
    void exceptionOnGetLegBecauseUnicornIdMissingFromIdentity() {
        var queryLegDto = new GetLegUsecase.QueryLegDto(null, Leg.LegPosition.FRONT_LEFT);

        assertThatThrownBy(() -> getLegUsecase.getLeg(queryLegDto)).isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    void exceptionOnGetLegBecauseLegPositionMissingFromIdentity() {
        var queryLegDto = new GetLegUsecase.QueryLegDto(savedUnicorn.getUnicornId(), null);

        assertThatThrownBy(() -> getLegUsecase.getLeg(queryLegDto)).isInstanceOf(ConstraintViolationException.class);
    }

    @Test
    void exceptionOnUpdateBecauseUnicornNotFound() {
        var queryLegDto = new GetLegUsecase.QueryLegDto(UnicornId.of("00000000-0000-0000-0000-000000000000"), Leg.LegPosition.FRONT_LEFT);

        assertThatThrownBy(() -> getLegUsecase.getLeg(queryLegDto)).isInstanceOf(UnicornNotFoundException.class);
    }

}
