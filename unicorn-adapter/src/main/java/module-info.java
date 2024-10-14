module nl.pancompany.unicorn.adapter.unicorn {

    exports nl.pancompany.unicorn.adapter.unicorn.out.financialhealth;

    requires transitive nl.pancompany.unicorn.application.unicorn;

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
    requires spring.webmvc;
    requires jakarta.validation;
    requires jakarta.transaction;

}