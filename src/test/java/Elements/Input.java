package Elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input extends BaseElement {
    final String textInputLOC = "//*[text()='%s']/ancestor::div/div/input";
    final String textInputStepLOC = "//*[text()='%s']/ancestor::div[contains(@id,'Group')]//p";

    public Input(WebDriver driver, String label) {
        super(driver, label);
    }
    @Step("Setting {text} into text input")
    public void write(String text) {
        driver.findElement(By.xpath(String.format(textInputLOC, label))).sendKeys(text);
        log.info(String.format("Setting %s into %s input", text, label));

    }
    @Step("Setting {text} into step input")
    public void writeSteps(String text) {
        driver.findElement(By.xpath(String.format(textInputStepLOC, label))).sendKeys(text);
        log.info(String.format("Setting %s into %s input", text, label));

    }
}
