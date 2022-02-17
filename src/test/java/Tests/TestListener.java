package Tests;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AllureUtils;

@Log4j2
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
    }

    @SneakyThrows
    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test "+result.getName()+" completed successfully.");
      }

    @SneakyThrows
    @Override
    public void onTestFailure(ITestResult result) {
        log.error("Test "+result.getName()+" failed.");
        WebDriver driver =(WebDriver)(result.getTestContext().getAttribute("driver"));
        AllureUtils.attachScreenshot(driver);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.error("Test "+result.getName()+" skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        log.error("Test "+result.getName()+" failed. Waiting period expired.");
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
