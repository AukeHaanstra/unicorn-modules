/**
 * Module used for inter-context communication (ports)
 * and cross-cutting concerns
 */
module nl.pancompany.unicorn.application {

    exports nl.pancompany.unicorn.application.port;
    exports nl.pancompany.unicorn.application.domain.model;

    requires transitive nl.pancompany.unicorn.common;

    requires static lombok;

}