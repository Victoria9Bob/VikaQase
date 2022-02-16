package Elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class FormatedTextElement extends BaseElement {

    private final static String VISIBLE_TEXT_DROPDOWN_LOC = "//*[text()='%s']/ancestor::div/div/button/div[contains(@class,'valueContent')]";
    private final static String VISIBLE_TEXT_INPUT_LOCATOR = "//*[text()='%s']/ancestor::section/div/div//p";
    private final static String VISIBLE_TEXT_TITLE = "//div[contains(@class,'caseView')]/h1/div";
    private final static String SUITE_NAME_LOCATOR = "//*[text()='%s']/ancestor::div/div/div/h3/span";
    private final static String STEP_LOCATOR = "//td[contains(@style,'word-break')][%s]//p";

    public FormatedTextElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getValue() {
        log.info(String.format("Take value from %s", label));
        return driver.findElement(By.xpath(String.format(VISIBLE_TEXT_DROPDOWN_LOC, label))).getText();
    }

    public String getVisibleText() {
        log.info(String.format("Take value from %s", label));
        return driver.findElement(By.xpath(String.format(VISIBLE_TEXT_INPUT_LOCATOR, label))).getText();
    }

    public String getTextTitle() {
        log.info(String.format("Take value from %s", label));
        return driver.findElement(By.xpath((VISIBLE_TEXT_TITLE))).getText();
    }

    public String getSuiteName(String caseName) {
        log.info(String.format("Take value from %s", label));
        return driver.findElement(By.xpath(String.format(SUITE_NAME_LOCATOR, caseName))).getText();
    }

    public String getStepText(int stepNumber) {
        log.info(String.format("Take value from %s", label));
        return driver.findElement(By.xpath(String.format(STEP_LOCATOR, stepNumber))).getText();
    }
}

