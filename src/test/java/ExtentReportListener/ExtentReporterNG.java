package ExtentReportListener;

import Config.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExtentReporterNG implements IReporter
{
    public ExtentReports extent;
    public WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    //public ExtentReports extent;
    public ExtentTest logger;
    public static TestBase tBase;

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        //extent = new ExtentReports(outputDirectory + File.separator + "ExtentReportTestNG.html", true);
        // initialize the HtmlReporter
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/TestExecutionReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "QA");
        extent.setSystemInfo("Environment", "QA Environment");
        extent.setSystemInfo("User Name", "Santosh Pandhare");
        htmlReporter.config().setDocumentTitle("QA Test Report");
        // Name of the report
        htmlReporter.config().setReportName("QA Test Report");
        // Dark Theme
        for (ISuite suite : suites)
        {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values())
            {
                ITestContext context = r.getTestContext();
                buildTestNodes(context.getPassedTests(), Status.PASS);
                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
            }
        }
        extent.flush();
      //  extent.close();
    }

    private void buildTestNodes(IResultMap tests, Status status)
    {
        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults())
            {
               // test = extent.startTest(result.getMethod().getMethodName());
                test = extent.createTest(result.getMethod().getMethodName());
               // test.getModel().setStartTime(test.getModel().getStartTime());
              //  test.getModel().setStartTime(test.getModel().getEndTime());
               // test.getTest().startedTime = getTime(result.getStartMillis());
               // test.getTest().endedTime = getTime(result.getEndMillis());
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
                String message = "Test " + status.toString().toLowerCase() + "ed";
                if (result.getThrowable() != null)
                    message = result.getThrowable().getMessage();
                test.log(status, message);
                //extent.endTest(test);
            }
        }
    }

    private Date getTime(long millis)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
    //This method is to capture the screenshot and return the path of the screenshot.
    public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException
    {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) TestBase.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
        String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }
    @AfterMethod
    public void getResult(ITestResult result) throws Exception
    {
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
            String screenshotPath = getScreenShot(TestBase.driver, result.getName());
            logger.pass("Test Case passed Snapshot is at below " + logger.addScreenCaptureFromPath(screenshotPath,"Test Passed"));
            logger.addScreenCaptureFromPath(screenshotPath,"Test Passed");
        }
        TestBase.driver.quit();
    }

    @AfterTest
    public void endReport()
    {
        extent.flush();
    }
}