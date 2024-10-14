module nl.pancompany.unicorn.application.finance {
    requires transitive nl.pancompany.unicorn.application;
    requires org.slf4j;
    requires lombok;
    exports nl.pancompany.unicorn.application.finance.port.in;
    exports nl.pancompany.unicorn.application.finance.domain.model;
    exports nl.pancompany.unicorn.application.finance.port.out;
}