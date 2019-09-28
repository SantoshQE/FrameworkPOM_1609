package Listeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import Config.TestBase;
import ExtentReportListener.ExtentManager;
import Utils.TestUtil;
import com.aventstack.extentreports.ExtentReports;
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
    public static ExtentTest extentTestbase;
    // private ExtentTest test;
   @Override
   public void onTestSuccess(ITestResult arg0)
   {
       System.out.println("Entered the onTestSuccess method...");
      // extentTest = report.createTest(arg0.getName().toUpperCase());
       extentTestbase = report.createTest(arg0.getName().toUpperCase());
      // System.setProperty("org.uncommons.reportng.escape-output","false");
       try
       {
           screenshotPath = TestUtil.captureScreenshot();
       } catch (IOException e)
       {
           e.printStackTrace();
       }
       extentTestbase.log(Status.PASS,arg0.getName().toUpperCase());
     //  TestBase.extentTest.log(Status.PASS,arg0.getTestName().toString());
       try {
           // System.out.println(screenshotPath);
           extentTestbase.log(Status.PASS, "Please refer below Snapshot: " + extentTestbase.addScreenCaptureFromPath(screenshotPath.toString()));
       } catch (IOException e)
       {
           e.printStackTrace();
       }
       //report.flush();
   }
    @Override
    public void onTestFailure(ITestResult arg0)
    {
        System.out.println("Entered the onTestFailure method...");
        extentTestbase = report.createTest(arg0.getName().toUpperCase());
        System.setProperty("org.uncommons.reportng.escape-output","false");
        try {
            screenshotPath = TestUtil.captureScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        extentTestbase.log(Status.FAIL, arg0.getName().toUpperCase()+" Failed with exception : "+arg0.getThrowable().getMessage().substring(0,arg0.getThrowable().getMessage().toString().indexOf("For documentation on this error")));
        try {
            // System.out.println(screenshotPath);
            extentTestbase.log(Status.FAIL, "Please refer below Snapshot: " + extentTestbase.addScreenCaptureFromPath(screenshotPath.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
       // report.flush();
    }
    @Override
    public void onFinish(ITestContext arg0)
    {
        System.out.println("Entered the onFinish -- ITestContext -- method...");
        // TODO Auto-generated method stub
     //   report.flush();
    }
    @Override
    public void onFinish(ISuite arg0) {
        System.out.println("Entered the onFinish -- ISuite -- method...");
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
        report.flush();
    }
    @Override
    public void onStart(ITestContext arg0)
    {
        System.out.println("Entered the onStart -- ITestContext -- method...");
        // TODO Auto-generated method stub
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        System.out.println("Entered the onTestFailedButWithinSuccessPercentage method...");
        // TODO Auto-generated method stub
    }

    @Override
    public void onTestSkipped(ITestResult arg0)
    {
        System.out.println("Entered the onTestSkipped method...");
        extentTestbase.log(Status.SKIP, arg0.getName().toUpperCase()+" Skipped the test");
      //  report.endTest(test);
       // report.flush();
    }
    @Override
    public void onTestStart(ITestResult arg0) {
        System.out.println("Entered the onTestStart method...");
       // extentTest = report.createTest(arg0.getName().toUpperCase());
    }


    @Override
    public void onStart(ISuite arg0) {
        System.out.println("Entered the onStart -- ISuite -- method...");
        // TODO Auto-generated method stub
    }
}
