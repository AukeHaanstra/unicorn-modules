module nl.pancompany.unicorn.application.unicorn {

    exports nl.pancompany.unicorn.application.unicorn.port.in;
    exports nl.pancompany.unicorn.application.unicorn.domain.model;
    exports nl.pancompany.unicorn.application.unicorn.port.out;
    exports nl.pancompany.unicorn.application.unicorn.usecase.exception;
    exports nl.pancompany.unicorn.application.unicorn.domain.service.dto;
    exports nl.pancompany.unicorn.application.unicorn;

    requires transitive nl.pancompany.unicorn.application;

    requires org.slf4j;
    requires jakarta.validation;
    requires lombok;
    requires org.mapstruct;

}