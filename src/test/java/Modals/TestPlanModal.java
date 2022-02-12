package Modals;

import Elements.Input;
import Models.TestPlans;
import Pages.TestPlansPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TestPlanModal extends BaseModal {
    final By SAVE_PLAN = By.id("save-plan");
    final By ADD_CASES_BUTTON = By.id("edit-plan-add-cases-button");

    public TestPlanModal(WebDriver driver) {
        super(driver);
    }

    public TestPlanModal fillForm(TestPlans testPlans) {
        if (testPlans.getTitle() != null) {
            new Input(driver, "Title").write(testPlans.getTitle());
        }
        if (testPlans.getDescription() != null) {
            new Input(driver, "Description").write(testPlans.getDescription());
        }
        return this;
    }

    public TestPlansPage savePlan() {
        driver.findElement(SAVE_PLAN).click();
        log.info("Click save button");
        return new TestPlansPage(driver);
    }
    public SelectTestCasesModal addCases() {
        jsClick(driver.findElement(ADD_CASES_BUTTON));
        log.info("Add cases.");
        return new SelectTestCasesModal(driver);
    }
}
