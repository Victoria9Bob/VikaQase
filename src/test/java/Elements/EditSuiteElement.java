package Elements;


import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class EditSuiteElement extends BaseElement {
    final String textInputLOC = "//*[text()='%s']/ancestor::div/div/input";
    final String drobdownLOC = "css-io3r9z-singleValue";
    private static final String optionLOC = "//*[text()='%s']/ancestor::div//*[text()='%s']";

    public EditSuiteElement(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getDrobdownSuiteValue() {
        return driver.findElement(By.className(drobdownLOC)).getText();
    }

    public String getInputSuiteValue() {
        return driver.findElement(By.xpath(String.format(textInputLOC, label))).getAttribute("value");
    }
}
