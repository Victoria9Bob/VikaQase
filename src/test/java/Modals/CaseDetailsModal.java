package Modals;

import Elements.FormatedTextElement;
import Enums.*;
import Models.Case;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CaseDetailsModal extends BaseModal {
    public CaseDetailsModal(WebDriver driver) {
        super(driver);
    }
    @Step("Get case details info")
    public Case getCaseDetailsInfo(String caseName) {
        Case resultCase = new Case();
        String title = new FormatedTextElement(driver, "Title").getTextTitle();
        if (title != null) {
            resultCase.setTitle(title);
        }
        String status = new FormatedTextElement(driver, "Status").getValue();
        if (status != null) {
            resultCase.setStatus(CaseStatus.fromString(status));
        }
        String description = new FormatedTextElement(driver, "Description").getVisibleText();
        if (description != null) {
            resultCase.setDescription(description);
        }
        String suite = new FormatedTextElement(driver, "Suite").getSuiteName(caseName);
        if (suite != null) {
            resultCase.setSuite(CaseSuite.fromString(suite));
        }
        String severity = new FormatedTextElement(driver, "Severity").getValue();
        if (severity != null) {
            resultCase.setSeverity(CaseSeverity.fromString(severity));
        }
        String priority = new FormatedTextElement(driver, "Priority").getValue();
        if (priority != null) {
            resultCase.setPriority(CasePriority.fromString(priority));
        }
        String type = new FormatedTextElement(driver, "Type").getValue();
        if (type != null) {
            resultCase.setType(CaseType.fromString(type));
        }
        String layer = new FormatedTextElement(driver, "Layer").getValue();
        if (layer != null) {
            resultCase.setLayer(CaseLayer.fromString(layer));
        }
        String isFlaky = new FormatedTextElement(driver, "Is Flaky").getValue();
        if (isFlaky != null) {
            resultCase.setIsFlaky(CaseIsFlaky.fromString(isFlaky));
        }
        String milestone = new FormatedTextElement(driver, "Milestone").getValue();
        if (milestone != null) {
            resultCase.setMilestone(CaseMilestone.fromString(milestone));
        }
        String behavior = new FormatedTextElement(driver, "Behavior").getValue();
        if (behavior != null) {
            resultCase.setBehavior(CaseBehavior.fromString(behavior));
        }
        String automationStatus = new FormatedTextElement(driver, "Automation").getValue();
        if (automationStatus != null) {
            resultCase.setAutomationStatus(CaseAutomationStatus.fromString(automationStatus));
        }
        String pre_conditions = new FormatedTextElement(driver, "Preconditions").getVisibleText();
        if (pre_conditions != null) {
            resultCase.setPre_conditions(pre_conditions);
        }
        String post_conditions = new FormatedTextElement(driver, "Postconditions").getVisibleText();
        if (post_conditions != null) {
            resultCase.setPost_conditions(post_conditions);
        }
        String action = new FormatedTextElement(driver, "Action").getStepText(1);
        if (action != null) {
            resultCase.setAction(action);
        }
        String inputData = new FormatedTextElement(driver, "Input data").getStepText(2);
        if (inputData != null) {
            resultCase.setInputData(inputData);
        }
        String expectedResult = new FormatedTextElement(driver, "Expected result").getStepText(3);
        if (expectedResult != null) {
            resultCase.setExpectedResult(expectedResult);
        }
        return resultCase;
    }
}
