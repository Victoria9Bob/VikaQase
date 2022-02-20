package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input extends BaseElement {
    private final static String TEXT_INPUT_LOCATOR = "//*[text()='%s']/ancestor::div/div/input";

    public Input(WebDriver driver, String label) {
        super(driver, label);
    }

    public void write(String text) {
        log.info(String.format("Setting %s into %s input", text, label));
        driver.findElement(By.xpath(String.format(TEXT_INPUT_LOCATOR, label))).sendKeys(text);
    }
}
