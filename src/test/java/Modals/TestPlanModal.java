package Modals;

import Elements.Input;
import Models.TestPlans;
import Pages.TestPlansPage;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    public TestPlansPage savePlan() {
        driver.findElement(SAVE_PLAN).click();
        log.info("Click save button");
        return new TestPlansPage(driver);
    }
    @Step("Add cases.")
    public SelectTestCasesModal addCases() {
        jsClick(driver.findElement(ADD_CASES_BUTTON));
        log.info("Add cases.");
        return new SelectTestCasesModal(driver);
    }
}
