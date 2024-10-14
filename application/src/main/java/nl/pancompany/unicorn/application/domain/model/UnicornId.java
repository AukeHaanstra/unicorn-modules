package nl.pancompany.unicorn.application.domain.model;

import lombok.Value;

import java.util.UUID;

@Value(staticConstructor = "of")
public class UnicornId {

    UUID value;

    public String toStringValue() {
        return value.toString();
    }

    public static UnicornId generate() {
        return new UnicornId(UUID.randomUUID());
    }

    public static UnicornId of(String uuid) {
        return new UnicornId(UUID.fromString(uuid));
    }
}
