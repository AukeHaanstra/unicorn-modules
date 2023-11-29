package nl.pancompany.unicorn.application.domain.model;

import java.util.HashSet;
import java.util.Set;

public record Unicorn(UnicornId id, Set<Leg> legs) {

    public void colorPart(PartId partId, Color color) {
        Set<ColorablePart> parts = new HashSet<>();
        parts.addAll(legs);
        // add other parts
        parts.stream().filter(part -> part.getId().equals(partId)).forEach(part -> part.setColor(color));
    }

    public record UnicornId(Long value) {

        public static UnicornId of(Long value) {
            return new UnicornId(value);
        }
    }
}