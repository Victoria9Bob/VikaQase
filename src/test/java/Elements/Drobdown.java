package Elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class Drobdown extends BaseElement {
    private final static String DROPDOWN_LOCATOR = "//*[text()='%s']/ancestor::div/div/div[contains(@class,'notranslate')]";
    private final static String OPTION_LOCATOR = "//*[text()='%s']/following::div[contains(text(),'%s')]";

    public Drobdown(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectOption(String optionName) {
        log.info(String.format("Select an option: %s", optionName));
        driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, label))).click();
        WebElement optionToClick = driver.findElement(By.xpath(String.format(OPTION_LOCATOR, label, optionName)));
        scrollIntoView(optionToClick);
        optionToClick.click();
    }
}
