module nl.pancompany.unicorn.adapter.finance {
    exports nl.pancompany.unicorn.adapter.finance.in;
    requires transitive nl.pancompany.unicorn.application.finance;
    requires spring.web;
    requires lombok;
    requires com.fasterxml.jackson.databind;
    requires json.patch;
    requires org.slf4j;
    requires jakarta.persistence;
    requires org.mapstruct;
    requires spring.context;
    requires spring.core;
    requires spring.beans;
    requires spring.data.jpa;
    requires spring.boot.autoconfigure;
}