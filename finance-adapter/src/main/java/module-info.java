module nl.pancompany.unicorn.adapter.finance {

    exports nl.pancompany.unicorn.adapter.finance.in.calculatesales;

    requires transitive nl.pancompany.unicorn.application.finance;

    requires lombok;
    requires org.mapstruct;
}