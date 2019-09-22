package Listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import Config.TestBase;
import Utils.TestUtil;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath;
/*import TestUtil.MonitoringMail;
import com.w2a.utilities.TestConfig;*/

public class CustomListeners extends TestBase implements ITestListener,ISuiteListener {
    public 	String messageBody;
    public static TestUtil TUtil;
    public static String screenshotPath;


    public void onFinish(ITestContext arg0) {
        // TODO Auto-generated method stub
       // report.flush();
    }
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
    }
    public void onTestFailure(ITestResult arg0)
    {
       // test = report.createTest(arg0.getName().toUpperCase());
        System.setProperty("org.uncommons.reportng.escape-output","false");
        try {
             screenshotPath = TestUtil.captureScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTest.log(Status.FAIL, arg0.getName().toUpperCase()+" Failed with exception : "+arg0.getThrowable().getMessage().substring(0,arg0.getThrowable().getMessage().toString().indexOf("For documentation on this error")));
        try {
            // System.out.println(screenshotPath);
            extentTest.log(Status.FAIL, "Please refer below Snapshot: " + extentTest.addScreenCaptureFromPath(screenshotPath.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        report.flush();
    }
    public void onTestSkipped(ITestResult arg0)
    {
        extentTest.log(Status.SKIP, arg0.getName().toUpperCase()+" Skipped the test");
      //  report.endTest(test);
        report.flush();
    }
    public void onTestStart(ITestResult arg0) {
        extentTest = report.createTest(arg0.getName().toUpperCase());
    }
    public void onTestSuccess(ITestResult arg0) {
      /*  test.log(Status.PASS, arg0.getName().toUpperCase()+" PASS");
        // test = report.createTest(arg0.getName().toUpperCase()); */
     /*   System.setProperty("org.uncommons.reportng.escape-output","false");
        try {
            screenshotPath = TestUtil.captureScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.log(Status.PASS, arg0.getName().toUpperCase()+" Test Passed : "+arg0.getThrowable().getMessage());
        try {
           // System.out.println(screenshotPath);
            test.log(Status.PASS, "Snapshot below: " + test.addScreenCaptureFromPath(screenshotPath.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        report.flush();*/
    }
    public void onFinish(ISuite arg0) {
/*        MonitoringMail mail = new MonitoringMail();
        try {
            messageBody = "http://" + InetAddress.getLocalHost().getHostAddress()
                    + ":8080/job/DataDrivenLiveProject/Extent_Reports/";
        } catch (UnknownHostException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            mail.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, messageBody);
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
      //  report.flush();
    }
    public void onStart(ISuite arg0) {
        // TODO Auto-generated method stub
    }
}
