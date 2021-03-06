package modals;

import elements.Dropdown;
import elements.Input;
import elements.InputSteps;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Case;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.RepositoryPage;

@Log4j2
public class CaseModal extends BaseModal {
    public static final By SAVE_CASE = By.id("save-case");
    public static final By ADD_STEP = By.id("add-step");

    public CaseModal(WebDriver driver) {
        super(driver);
    }

    @Step("Fill case form.")
    public CaseModal fillForm(Case aCase) {
        if (aCase.getTitle() != null) {
            new Input(driver, "Title").write(aCase.getTitle());
        }
        if (aCase.getStatus() != null) {
            new Dropdown(driver, "Status").selectOption(aCase.getStatus().getName());
        }
        if (aCase.getDescription() != null) {
            new Input(driver, "Description").write(aCase.getDescription());
        }
        if (aCase.getSuite() != null) {
            new Dropdown(driver, "Suite").selectOption(aCase.getSuite().getName());
        }
        if (aCase.getSeverity() != null) {
            new Dropdown(driver, "Severity").selectOption(aCase.getSeverity().getName());
        }
        if (aCase.getPriority() != null) {
            new Dropdown(driver, "Priority").selectOption(aCase.getPriority().getName());
        }
        if (aCase.getType() != null) {
            new Dropdown(driver, "Type").selectOption(aCase.getType().getName());
        }
        if (aCase.getLayer() != null) {
            new Dropdown(driver, "Layer").selectOption(aCase.getLayer().getName());
        }
        if (aCase.getIsFlaky() != null) {
            new Dropdown(driver, "Is Flaky").selectOption(aCase.getIsFlaky().getName());
        }
        if (aCase.getMilestone() != null) {
            new Dropdown(driver, "Milestone").selectOption(aCase.getMilestone().getName());
        }
        if (aCase.getBehavior() != null) {
            new Dropdown(driver, "Behavior").selectOption(aCase.getBehavior().getName());
        }
        if (aCase.getAutomationStatus() != null) {
            new Dropdown(driver, "Automation status").selectOption(aCase.getAutomationStatus().getName());
        }
        if (aCase.getPre_conditions() != null) {
            new Input(driver, "Pre-conditions").write(aCase.getPre_conditions());
        }
        if (aCase.getPost_conditions() != null) {
            new Input(driver, "Post-conditions").write(aCase.getPost_conditions());
        }
        addStepButton();
        if (aCase.getAction() != null) {
            new InputSteps(driver, "Action").writeSteps(

                    aCase.getAction());
        }
        if (aCase.getInputData() != null) {
            new InputSteps(driver, "Input data").writeSteps(aCase.getInputData());
        }
        if (aCase.getExpectedResult() != null) {
            new InputSteps(driver, "Expected result").writeSteps(aCase.getExpectedResult());
        }
        return this;
    }

    @Step("Save Case.")
    public RepositoryPage clickSaveCaseButton() {
        log.info("Click save button");
        driver.findElement(SAVE_CASE).click();
        return new RepositoryPage(driver);
    }

    @Step("Add step.")
    public CaseModal addStepButton() {
        log.info("Add step");
        driver.findElement(ADD_STEP).click();
        return this;
    }
}
