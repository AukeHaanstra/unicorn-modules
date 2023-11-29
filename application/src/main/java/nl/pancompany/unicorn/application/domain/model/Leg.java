package nl.pancompany.unicorn.application.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Leg implements ColorablePart {

        private final PartId id;

        @Setter
        private Color color;

}
