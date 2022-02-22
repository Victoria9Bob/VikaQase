package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

public class BasePage {
    protected final static String BASE_URL = System.getenv().getOrDefault("BASE_URL", PropertyReader.getProperty("qase.base_url"));
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public boolean isPageOpened() {
        return false;
    }

    public boolean isErrorMessageDisplayed() {
        return false;
    }

    public BasePage open() {
        return null;
    }


    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    public void jsClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}

