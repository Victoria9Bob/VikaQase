package Elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class InputSteps extends BaseElement {
    private final static String TEXT_INPUT_STEP_LOCATOR = "//*[text()='%s']/ancestor::div[contains(@id,'Group')]//p";

    public InputSteps(WebDriver driver, String label) {
        super(driver, label);
    }

    public void writeSteps(String text) {
        log.info(String.format("Setting %s into %s input", text, label));
        driver.findElement(By.xpath(String.format(TEXT_INPUT_STEP_LOCATOR, label))).sendKeys(text);
    }
}
