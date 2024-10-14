module nl.pancompany.unicorn.application.unicorn {
    requires jakarta.transaction;
    requires jakarta.validation;
    requires spring.context;
    requires org.slf4j;
    requires lombok;
    exports nl.pancompany.unicorn.application.port.in;
    exports nl.pancompany.unicorn.application.domain.model;
    exports nl.pancompany.unicorn.application.port.out;
}