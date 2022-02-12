package Modals;

import Elements.FormatedTextElement;
import Enums.*;
import Models.Case;
import org.openqa.selenium.WebDriver;

public class CaseDetailsModal extends BaseModal {
    public CaseDetailsModal(WebDriver driver) {
        super(driver);
    }

    public Case getCaseDetailsInfo(String caseName) {
        Case aCase = new Case();
        String title = new FormatedTextElement(driver, "Title").getTextTitle();
        if (title != null) {
            aCase.setTitle(title);
        }
        String status = new FormatedTextElement(driver, "Status").getValue();
        if (status != null) {
            aCase.setStatus(CaseStatus.fromString(status));
        }
        String description = new FormatedTextElement(driver, "Description").getVisibleText();
        if (description != null) {
            aCase.setDescription(description);
        }
        String suite = new FormatedTextElement(driver, "Suite").getSuiteName(caseName);
        if (suite != null) {
            aCase.setSuite(CaseSuite.fromString(suite));
        }
        String severity = new FormatedTextElement(driver, "Severity").getValue();
        if (severity != null) {
            aCase.setSeverity(CaseSeverity.fromString(severity));
        }
        String priority = new FormatedTextElement(driver, "Priority").getValue();
        if (priority != null) {
            aCase.setPriority(CasePriority.fromString(priority));
        }
        String type = new FormatedTextElement(driver, "Type").getValue();
        if (type != null) {
            aCase.setType(CaseType.fromString(type));
        }
        String layer = new FormatedTextElement(driver, "Layer").getValue();
        if (layer != null) {
            aCase.setLayer(CaseLayer.fromString(layer));
        }
        String isFlaky = new FormatedTextElement(driver, "Is Flaky").getValue();
        if (isFlaky != null) {
            aCase.setIsFlaky(CaseIsFlaky.fromString(isFlaky));
        }
        String milestone = new FormatedTextElement(driver, "Milestone").getValue();
        if (milestone != null) {
            aCase.setMilestone(CaseMilestone.fromString(milestone));
        }
        String behavior = new FormatedTextElement(driver, "Behavior").getValue();
        if (behavior != null) {
            aCase.setBehavior(CaseBehavior.fromString(behavior));
        }
        String automationStatus = new FormatedTextElement(driver, "Automation").getValue();
        if (automationStatus != null) {
            aCase.setAutomationStatus(CaseAutomationStatus.fromString(automationStatus));
        }
        String pre_conditions = new FormatedTextElement(driver, "Preconditions").getVisibleText();
        if (pre_conditions != null) {
            aCase.setPre_conditions(pre_conditions);
        }
        String post_conditions = new FormatedTextElement(driver, "Postconditions").getVisibleText();
        if (post_conditions != null) {
            aCase.setPost_conditions(post_conditions);
        }
        return aCase;
    }
}
