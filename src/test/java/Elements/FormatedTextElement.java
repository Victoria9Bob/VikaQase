package Elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class FormatedTextElement extends BaseElement {

    private String visibleTextDrobdownLoc = "//*[text()='%s']/ancestor::div/div/button/div[contains(@class,'valueContent')]";
    private String visibleTextInputLoc = "//*[text()='%s']/ancestor::section/div/div//p";
    private String visibleTextTitle = "//div[contains(@class,'caseView')]/h1/div";
    private String suiteNameLoc = "//*[text()='%s']/ancestor::div/div/div/h3/span";
    private String step_Loc = "//td[contains(@style,'word-break')][%s]//p";

    public FormatedTextElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getValue() {
        log.info(String.format("Take value from %s", label));
        return driver.findElement(By.xpath(String.format(visibleTextDrobdownLoc, label))).getText();
    }

    public String getVisibleText() {
        log.info(String.format("Take value from %s", label));
        return driver.findElement(By.xpath(String.format(visibleTextInputLoc, label))).getText();
    }

    public String getTextTitle() {
        log.info(String.format("Take value from %s", label));
        return driver.findElement(By.xpath((visibleTextTitle))).getText();
    }

    public String getSuiteName(String caseName) {
        log.info(String.format("Take value from %s", label));
        return driver.findElement(By.xpath(String.format(suiteNameLoc, caseName))).getText();
    }

    public String getStepText(int stepNumber) {
        log.info(String.format("Take value from %s", label));
        return driver.findElement(By.xpath(String.format(step_Loc, stepNumber))).getText();
    }
}

