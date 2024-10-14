module nl.pancompany.unicorn.application.unicorn {
    requires transitive nl.pancompany.unicorn.application;
    requires jakarta.transaction;
    requires jakarta.validation;
    requires spring.context;
    requires org.slf4j;
    requires lombok;
    requires org.mapstruct;
    exports nl.pancompany.unicorn.application.unicorn.port.in;
    exports nl.pancompany.unicorn.application.unicorn.domain.model;
    exports nl.pancompany.unicorn.application.unicorn.port.out;
    exports nl.pancompany.unicorn.application.unicorn.usecase.exception;
    exports nl.pancompany.unicorn.application.unicorn.domain.service;
    exports nl.pancompany.unicorn.application.unicorn;
}