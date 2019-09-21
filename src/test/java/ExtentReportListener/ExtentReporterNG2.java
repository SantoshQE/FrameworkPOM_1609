package ExtentReportListener;

import Config.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.IReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;*/

public class ExtentReporterNG2 extends TestBase implements IReporter
{
    public WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;
    public static TestBase tBase;

    @BeforeTest
    public void startReport() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/STMExtentReport.html");
        // Create an object of Extent Reports
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "TCS");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User Name", "Santosh Pandhare");
        htmlReporter.config().setDocumentTitle("QA Test Report ");
        // Name of the report
        htmlReporter.config().setReportName("QA Test Report ");
        // Dark Theme
        htmlReporter.config().setTheme(Theme.STANDARD);
    }
    //This method is to capture the screenshot and return the path of the screenshot.
    public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) TestBase.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }
    @BeforeMethod
    public void setup()
    {
/*        System.setProperty("webdriver.chrome.driver","C://AutomationFramework//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
       // tBase = new TestBase();*/
        TestBase.open_Browser("Chrome");
     //   driver.get("https://www.google.com");
        TestBase.driver.get("https://www.google.com");
    }
    @Test
    public void verifyTitle()
    {
        logger = extent.createTest("To verify Google Title");
        Assert.assertEquals(TestBase.driver.getTitle(),"Google");
    }
    @Test
    public void verifyLogo()
    {
        logger = extent.createTest("To verify Google Logo");
        //boolean img = TestBase.driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
        boolean img = TestBase.driver.findElement(By.xpath("//*[@id='hplogo']/div[2]")).isDisplayed();
        // "//*[@id='hplogo']/div[2]"
        logger.createNode("Image is Present");
        Assert.assertTrue(img);
        logger.createNode("Image is not Present");
        try
        {
            Assert.assertFalse(img);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    @AfterMethod
    public void getResult(ITestResult result) throws Exception{
        if(result.getStatus() == ITestResult.FAILURE){
            //MarkupHelper is used to display the output in different colors
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.ORANGE));
            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
            //To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
            //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method.
            //String Scrnshot=TakeScreenshot.captuerScreenshot(driver,"TestCaseFailed");
            String screenshotPath = getScreenShot(TestBase.driver, result.getName());
            //To add it in the extent report
           // logger.fail("Test Case Failed Snapshot is at below " + logger.addScreenCaptureFromPath(screenshotPath.toString()));
            logger.fail("Test Case Failed Snapshot is at below " + logger.addScreenCaptureFromPath(screenshotPath,"Test Failed"));
            logger.addScreenCaptureFromPath(screenshotPath,"Test Failed");
        }
        else if(result.getStatus() == ITestResult.SKIP){
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        TestBase.driver.quit();
    }

    @AfterTest
    public void endReport() {
        extent.flush();
    }

}
