module test.common {

    requires nl.pancompany.unicorn.adapter.finance;
    requires nl.pancompany.unicorn.adapter.unicorn;
    requires nl.pancompany.unicorn.application.finance;
    requires nl.pancompany.unicorn.application.unicorn;
    requires org.mapstruct;
    requires spring.context;
    requires static lombok;

    exports nl.pancompany.unicorn.testcommon;
    exports nl.pancompany.unicorn.testcommon.testbuilders;
    exports nl.pancompany.unicorn.testcommon.testadapters.persistence;
}