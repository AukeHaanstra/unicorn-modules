module nl.pancompany.unicorn.adapter {
    requires spring.web;
    requires lombok;
    requires com.fasterxml.jackson.databind;
    requires nl.pancompany.unicorn.application;
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