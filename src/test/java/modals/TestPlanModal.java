package modals;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.TestPlans;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.TestPlansPage;

@Log4j2
public class TestPlanModal extends BaseModal {
    private static final By SAVE_PLAN = By.id("save-plan");
    private static final By ADD_CASES_BUTTON = By.id("edit-plan-add-cases-button");

    public TestPlanModal(WebDriver driver) {
        super(driver);
    }

    @Step("Fill test plan form.")
    public TestPlanModal fillForm(TestPlans testPlans) {
        if (testPlans.getTitle() != null) {
            new Input(driver, "Title").write(testPlans.getTitle());
        }
        if (testPlans.getDescription() != null) {
            new Input(driver, "Description").write(testPlans.getDescription());
        }
        return this;
    }

    @Step("Save plan.")
    public TestPlansPage clickSavePlan() {
        log.info("Click save button");
        driver.findElement(SAVE_PLAN).click();
        return new TestPlansPage(driver);
    }

    @Step("Add cases.")
    public SelectTestCasesModal clickAddCases() {
        log.info("Add cases.");
        jsClick(driver.findElement(ADD_CASES_BUTTON));
        return new SelectTestCasesModal(driver);
    }
}
