package modals;

import elements.EditSuiteElement;
import enums.SuiteParentSuite;
import io.qameta.allure.Step;
import models.Suite;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuiteEditFormModal extends BaseModal {
    private final static By DROPDOWN_LOCATOR = By.cssSelector("div[class$='singleValue']");

    public SuiteEditFormModal(WebDriver driver) {
        super(driver);
    }

    @Step("Get suite details info.")
    public Suite getSuiteDetailsInfo() {
        Suite suite = new Suite();
        String suiteName = new EditSuiteElement(driver, "Suite name").getInputSuiteValue();
        if (suiteName != null) {
            suite.setSuiteName(suiteName);
        }
        String parentSuite = getDropdownSuiteValue();
        if (parentSuite != null) {
            suite.setParentSuite(SuiteParentSuite.fromString(parentSuite));

        }
        String description = new EditSuiteElement(driver, "Description").getInputSuiteValue();
        if (description != null) {
            suite.setDescription(description);
        }
        String preconditions = new EditSuiteElement(driver, "Preconditions").getInputSuiteValue();
        if (preconditions != null) {
            suite.setPreconditions(preconditions);
        }
        return suite;
    }

    public String getDropdownSuiteValue() {
        return driver.findElement(DROPDOWN_LOCATOR).getText();
    }
}
