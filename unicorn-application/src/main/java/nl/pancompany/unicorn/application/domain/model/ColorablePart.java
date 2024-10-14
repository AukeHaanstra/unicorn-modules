package nl.pancompany.unicorn.application.domain.model;

public interface ColorablePart {

    PartId getId();
    Color getColor();
    void setColor(Color color);
}
