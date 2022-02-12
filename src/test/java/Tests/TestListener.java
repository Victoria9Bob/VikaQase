package Tests;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;


@Log4j2
public class TestListener implements ITestListener {
    private Object driver;

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
        this.driver = ((BaseTest)result.getInstance()).driver;
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File distfile = new File("/D:/Qase/target/"+result.getName()+".scr.jpg");
        FileUtils.copyFile(scrFile,distfile);
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
