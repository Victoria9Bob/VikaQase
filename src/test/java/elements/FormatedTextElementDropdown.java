package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class FormatedTextElementDropdown extends BaseElement {
    private final static String VISIBLE_TEXT_DROPDOWN_LOC = "//*[text()='%s']/ancestor::div/div/button/div[contains(@class,'valueContent')]";

    public FormatedTextElementDropdown(WebDriver driver, String label) {
        super(driver, label);
    }

    public String getValue() {
        log.info(String.format("Take value from %s", label));
        return driver.findElement(By.xpath(String.format(VISIBLE_TEXT_DROPDOWN_LOC, label))).getText();
    }
}

