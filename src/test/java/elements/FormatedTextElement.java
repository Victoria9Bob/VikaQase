package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2
public class FormatedTextElement extends BaseElement{
    private final static String VISIBLE_TEXT_INPUT_LOCATOR = "//*[text()='%s']/ancestor::section/div/div//p";

    public FormatedTextElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getVisibleText() {
        log.info(String.format("Take value from %s", label));
        return driver.findElement(By.xpath(String.format(VISIBLE_TEXT_INPUT_LOCATOR, label))).getText();
    }
}
