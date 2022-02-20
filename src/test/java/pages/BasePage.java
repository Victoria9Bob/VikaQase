package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;

public abstract class BasePage {
    protected final static String BASE_URL = System.getenv().getOrDefault("BASE_URL", PropertyReader.getProperty("qase.base_url"));
    protected final static String PROJECT_ID = System.getenv().getOrDefault("PROJECT_ID", PropertyReader.getProperty("qase.project_id"));
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public abstract boolean isPageOpened();

    public abstract boolean isErrorMessageDisplayed();

    public abstract BasePage open();


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

