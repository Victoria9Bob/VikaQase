package Modals;

import Elements.Drobdown;
import Elements.Input;
import Models.Suite;
import Pages.RepositoryPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class SuiteModal extends BaseModal {
    public static final By SAVE_SUITE = By.id("save-suite-button");

    public SuiteModal(WebDriver driver) {
        super(driver);
    }

    public SuiteModal fillForm(Suite suite) {
        if (suite.getSuiteName() != null) {
            new Input(driver, "Suite name").write(suite.getSuiteName());
        }
        if (suite.getParentSuite() != null) {
            new Drobdown(driver, "Parent suite").selectOption(suite.getParentSuite().getName());
        }
        if (suite.getDescription() != null) {
            new Input(driver, "Description").write(suite.getDescription());
        }
        if (suite.getPreconditions() != null) {
            new Input(driver, "Preconditions").write(suite.getPreconditions());
        }
        return this;
    }

    public RepositoryPage saveSuite() {
        driver.findElement(SAVE_SUITE).click();
        log.info("Click save button");
        return new RepositoryPage(driver);
    }
}

