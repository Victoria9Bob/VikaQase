package Modals;

import Elements.EditSuiteElement;
import Enums.SuiteParentSuite;
import Models.Suite;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;

@Log4j2
public class SuiteEditFormModal extends BaseModal {

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
        String parentSuite = new EditSuiteElement(driver, "Parent suite").getDrobdownSuiteValue();
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
}
