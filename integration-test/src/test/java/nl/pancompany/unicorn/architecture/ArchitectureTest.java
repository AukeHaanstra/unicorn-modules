package nl.pancompany.unicorn.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.Test;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
public class ArchitectureTest {

    @Test
    void unicornApplicationCoreDoesNotDependOnAdapters() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("nl.pancompany.unicorn");

        noClasses()
                .that()
                .resideInAPackage("nl.pancompany.unicorn.application.unicorn..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage("nl.pancompany.unicorn.adapter.unicorn..")
                .check(importedClasses);
    }

    @Test
    void financeApplicationCoreDoesNotDependOnAdapters() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("nl.pancompany.unicorn");

        noClasses()
                .that()
                .resideInAPackage("nl.pancompany.unicorn.application.finance..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage("nl.pancompany.unicorn.adapter.finance..")
                .check(importedClasses);
    }

    @Test
    void financeApplicationCoreDoesNotDependOnunicornApplicationCoreAndViceVersa() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("nl.pancompany.unicorn");

        noClasses()
                .that()
                .resideInAPackage("nl.pancompany.unicorn.application.finance..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage("nl.pancompany.unicorn.application.unicorn..")
                .check(importedClasses);

        noClasses()
                .that()
                .resideInAPackage("nl.pancompany.unicorn.application.unicorn..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage("nl.pancompany.unicorn.application.finance..")
                .check(importedClasses);
    }

    @Test
    void financeAdaptersDoNotDependOnunicornAdaptersAndViceVersa() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("nl.pancompany.unicorn");

        noClasses()
                .that()
                .resideInAPackage("nl.pancompany.unicorn.adapter.finance..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage("nl.pancompany.unicorn.adapter.unicorn..")
                .check(importedClasses);

        noClasses()
                .that()
                .resideInAPackage("nl.pancompany.unicorn.adapter.unicorn..")
                .should()
                .dependOnClassesThat()
                .resideInAnyPackage("nl.pancompany.unicorn.adapter.finance..")
                .check(importedClasses);
    }
}
