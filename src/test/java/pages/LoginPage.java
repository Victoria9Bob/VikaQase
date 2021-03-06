package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {
    private final static By SIGN_UP = By.linkText("Sign up");
    private final static By EMAIL_INPUT = By.id("inputEmail");
    private final static By PASSWORD_INPUT = By.id("inputPassword");
    private final static By CONFIRM_PASSWORD_INPUT = By.id("inputPasswordConfirm");
    private final static By CREATE_ACCOUNT_BUTTON = By.cssSelector("button");
    private final static By LOGIN_BUTTON = By.cssSelector("button");
    private final static By CHECKBOX_AGREEMENT = By.name("agreement");
    private final static By CONFIRM_MESSAGE = By.cssSelector("h1");
    private final static By ERROR_MESSAGE = By.xpath("//div[contains(text(),'be a valid email address.')]");

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

    @Step("Open page.")
    @Override
    public LoginPage open() {
        log.info("Open page");
        driver.get(BASE_URL);
        return this;
    }

    @Step("Setting:" +
            "email:{email}" +
            "password:{password}")
    public RepositoryPage signUp(String email, String password) {
        driver.findElement(SIGN_UP).click();
        log.info("Setting email and password");
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(CONFIRM_PASSWORD_INPUT).sendKeys(password);
        jsClick(driver.findElement(CHECKBOX_AGREEMENT));
        log.info("Click create account");
        driver.findElement(CREATE_ACCOUNT_BUTTON).click();
        return new RepositoryPage(driver);
    }

    @Step("Setting:" +
            "email:{email}" +
            "password:{password}")
    public ProjectsPage login(String email, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        log.info("Signed in.");
        return new ProjectsPage(driver);
    }
}
