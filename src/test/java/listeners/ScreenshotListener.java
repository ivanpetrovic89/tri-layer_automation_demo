package listeners;

import common.DriverInterface;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.util.Date;

/**
 * ScreenshotListener is a TestNG listener class that implements {@link ITestListener}.
 * <p>
 * It overrides the {@link ITestListener#onTestFailure(ITestResult)} method to take a screenshot of
 * the web page when a test case fails.
 */

public class ScreenshotListener implements ITestListener {
    /**
     * Overrides the {@link ITestListener#onTestFailure(ITestResult)} method
     * to take a screenshot of the web page when a test case fails.
     *
     * @param  testResult  the result of the test that was run
     */
    @Override
    public void onTestFailure(ITestResult testResult){
        try{
            DriverInterface currentClass = (DriverInterface) testResult.getInstance();
            WebDriver driver = currentClass.getDriver();
            takeScreenshot(driver, testResult);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Takes a screenshot of the web page and saves it to the 'screenshots' file.
     *
     * @param  driver      the web driver used to interact with the web page
     * @param  testResult  the result of the test that was run
     */
    public static void takeScreenshot(WebDriver driver, ITestResult testResult){
        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File tempFile = screenshot.getScreenshotAs(OutputType.FILE);

        Date date = new Date();
        String screenshotName = testResult.getName()+"_"+date.toString()
                .replace(":","_").replace(" ","_");
        try{
            FileUtils.copyFile(tempFile, new File("./screenshots/"+screenshotName+".png"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
