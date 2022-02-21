package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class FormatedTextElementSteps extends BaseElement {
    private final static String STEP_LOCATOR = "//td[contains(@style,'word-break')][%s]//p";

    public FormatedTextElementSteps(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getStepText(int stepNumber) {
        log.info(String.format("Take value from %s", label));
        return driver.findElement(By.xpath(String.format(STEP_LOCATOR, stepNumber))).getText();
    }
}
