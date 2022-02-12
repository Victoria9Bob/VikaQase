package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    final static By EMAIL_INPUT = By.id("inputEmail");
    final static By PASSWORD_INPUT = By.id("inputPassword");
    final static By CONFIRM_PASSWORD_INPUT = By.id("inputPasswordConfirm");
    final static By CREATE_ACCOUNT_BUTTON = By.cssSelector("button");
    final static By LOGIN_BUTTON = By.cssSelector("button");
    final static By CHECKBOX_AGREEMENT = By.name("agreement");
    final static By CONFIRM_MESSAGE = By.cssSelector("h1");
    final static By ERROR_MESSAGE = By.xpath("//div[contains(text(),'be a valid email address.')]");
    private String LOGIN_URL = "https://app.qase.io/login";


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public boolean isConfirmMessageDisplayed() {
        return driver.findElement(CONFIRM_MESSAGE).isDisplayed();
    }

    @Override
    public boolean isErrorMessageDisplayed() {
        return driver.findElement(ERROR_MESSAGE).isDisplayed();
    }

    @Override
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    public LoginPage openLoginPage() {
        driver.get(LOGIN_URL);
        return this;
    }

    public RepositoryPage signUp(String email, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(password);
        jsClick(driver.findElement(CHECKBOX_AGREEMENT));
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
        return new RepositoryPage(driver);
    }

    public ProjectsPage login(String email, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProjectsPage(driver);
    }
}
