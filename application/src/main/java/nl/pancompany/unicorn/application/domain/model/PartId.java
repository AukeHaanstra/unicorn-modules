package nl.pancompany.unicorn.application.domain.model;

public record PartId(Long value) {
    public static PartId of(Long value) {
        return new PartId(value);
    }
}
