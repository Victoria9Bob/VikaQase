package Elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class EditSuiteElement extends BaseElement {
    private final static String TEXT_INPUT_LOCATOR = "//*[text()='%s']/ancestor::div/div/input";
    private final static By DROPDOWN_LOCATOR =By.cssSelector("div[class$='singleValue']");

    public EditSuiteElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getDropdownSuiteValue() {
        return driver.findElement(DROPDOWN_LOCATOR).getText();
    }

    public String getInputSuiteValue() {
        return driver.findElement(By.xpath(String.format(TEXT_INPUT_LOCATOR, label))).getAttribute("value");
    }
}
