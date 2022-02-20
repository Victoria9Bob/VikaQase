package modals;

import elements.FormatedTextElement;
import elements.FormatedTextElementDropdown;
import elements.FormatedTextElementSteps;
import enums.*;
import models.Case;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CaseDetailsModal extends BaseModal {
    private final static String SUITE_NAME_LOCATOR = "//*[text()='%s']/ancestor::div/div/div/h3/span";
    private final static String VISIBLE_TEXT_TITLE = "//div[contains(@class,'caseView')]/h1/div";

    public CaseDetailsModal(WebDriver driver) {
        super(driver);
    }

    @Step("Get case details info")
    public Case getCaseDetailsInfo(String caseName) {
        Case resultCase = new Case();
        String title = getTextTitle("Title");
        resultCase.setTitle(title);

        String status = new FormatedTextElementDropdown(driver, "Status").getValue();
        resultCase.setStatus(CaseStatus.fromString(status));

        String description = new FormatedTextElement(driver, "Description").getVisibleText();
        resultCase.setDescription(description);

        String suite = getSuiteName(caseName, "Suite");
        resultCase.setSuite(CaseSuite.fromString(suite));

        String severity = new FormatedTextElementDropdown(driver, "Severity").getValue();
        resultCase.setSeverity(CaseSeverity.fromString(severity));

        String priority = new FormatedTextElementDropdown(driver, "Priority").getValue();
        resultCase.setPriority(CasePriority.fromString(priority));

        String type = new FormatedTextElementDropdown(driver, "Type").getValue();
        resultCase.setType(CaseType.fromString(type));

        String layer = new FormatedTextElementDropdown(driver, "Layer").getValue();
        resultCase.setLayer(CaseLayer.fromString(layer));

        String isFlaky = new FormatedTextElementDropdown(driver, "Is Flaky").getValue();
        resultCase.setIsFlaky(CaseIsFlaky.fromString(isFlaky));

        String milestone = new FormatedTextElementDropdown(driver, "Milestone").getValue();
        resultCase.setMilestone(CaseMilestone.fromString(milestone));

        String behavior = new FormatedTextElementDropdown(driver, "Behavior").getValue();
        resultCase.setBehavior(CaseBehavior.fromString(behavior));

        String automationStatus = new FormatedTextElementDropdown(driver, "Automation").getValue();
        resultCase.setAutomationStatus(CaseAutomationStatus.fromString(automationStatus));

        String pre_conditions = new FormatedTextElement(driver, "Preconditions").getVisibleText();
        resultCase.setPre_conditions(pre_conditions);

        String post_conditions = new FormatedTextElement(driver, "Postconditions").getVisibleText();
        resultCase.setPost_conditions(post_conditions);

        String action = new FormatedTextElementSteps(driver, "Action").getStepText(1);
        resultCase.setAction(action);

        String inputData = new FormatedTextElementSteps(driver, "Input data").getStepText(2);
        resultCase.setInputData(inputData);

        String expectedResult = new FormatedTextElementSteps(driver, "Expected result").getStepText(3);
        resultCase.setExpectedResult(expectedResult);

        return resultCase;
    }

    public String getSuiteName(String caseName, String label) {
        log.info(String.format("Take value from %s", label));
        return driver.findElement(By.xpath(String.format(SUITE_NAME_LOCATOR, caseName))).getText();
    }

    public String getTextTitle(String label) {
        log.info(String.format("Take value from %s", label));
        return driver.findElement(By.xpath((VISIBLE_TEXT_TITLE))).getText();
    }
}
