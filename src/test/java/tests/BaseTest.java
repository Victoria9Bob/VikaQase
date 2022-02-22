package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.LoginPage;
import pages.RepositoryPage;
import pages.TestPlansPage;
import utils.PropertyReader;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static final String EMAIL = System.getenv().getOrDefault("EMAIL", PropertyReader.getProperty("qase.email"));
    protected static final String PASSWORD = System.getenv().getOrDefault("PASSWORD", PropertyReader.getProperty("qase.password"));
    protected final static String PROJECT_ID = "/DEMO";
    protected LoginPage loginPage;
    protected RepositoryPage repositoryPage;
    protected TestPlansPage testPlansPage;

    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    @Step("Open browser")
    public void setUp(ITestContext testContext) {
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        testContext.setAttribute("driver", driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        repositoryPage = new RepositoryPage(driver);
        testPlansPage = new TestPlansPage(driver);
    }

    @Step("Close browser")
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
