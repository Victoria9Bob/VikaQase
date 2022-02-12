package Elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input extends BaseElement {
    final String textInputLOC = "//*[text()='%s']/ancestor::div/div/input";

    public Input(WebDriver driver, String label) {
        super(driver, label);
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(textInputLOC, label))).sendKeys(text);
        log.info(String.format("Setting %s into %s input", text, label));

    }
}
