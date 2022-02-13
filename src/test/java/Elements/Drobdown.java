package Elements;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class Drobdown extends BaseElement {
    final String drobdownLOC = "//*[text()='%s']/ancestor::div/div/div[contains(@class,'notranslate')]";
    final String optionLOC = "//*[text()='%s']/following::div[contains(text(),'%s')]";

    public Drobdown(WebDriver driver, String label) {
        super(driver, label);
    }

    public void selectOption(String optionName) {
        driver.findElement(By.xpath(String.format(drobdownLOC, label))).click();
        WebElement optionToClick = driver.findElement(By.xpath(String.format(optionLOC, label, optionName)));
        scrollIntoView(optionToClick);
        optionToClick.click();
        log.info(String.format("Select an option: %s", optionName));
    }
}
