package Tests;

import Pages.LoginPage;
import Pages.RepositoryPage;
import Pages.TestPlansPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static final String EMAIL = "bob123@mailinator.com";
    protected static final String PASSWORD = "qwe123asd";
    protected LoginPage loginPage;
    protected RepositoryPage repositoryPage;
    protected TestPlansPage testPlansPage;

    protected WebDriver driver;
    @BeforeClass(alwaysRun = true)
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        repositoryPage = new RepositoryPage(driver);
        testPlansPage = new TestPlansPage(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
