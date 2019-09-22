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
    }
    public void onStart(ITestContext arg0) {
        // TODO Auto-generated method stub
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        // TODO Auto-generated method stub
    }
    public void onTestFailure(ITestResult arg0)
    {
        test = report.createTest(arg0.getName().toUpperCase());
        System.setProperty("org.uncommons.reportng.escape-output","false");
        try {
             screenshotPath = TestUtil.captureScreenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.log(Status.FAIL, arg0.getName().toUpperCase()+" Failed with exception : "+arg0.getThrowable());
        try {
           // test.log(Status.FAIL, "Snapshot below: " + test.addScreenCaptureFromPath(TestUtil.screenshotName));
            System.out.println(screenshotPath);
           // test.log(Status.FAIL, "Snapshot below: " + test.addScreenCaptureFromPath(TestUtil.screenshotPath.toString()));
            test.log(Status.FAIL, "Snapshot below: " + test.addScreenCaptureFromPath(screenshotPath.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
  /*      Reporter.log("Click to see Screenshot");
        Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href="+TestUtil.screenshotName+"><img src="+TestUtil.screenshotName+" height=500 width=500></img></a>");
        //report.endTest(test);*/
   /*     Reporter.log("Click to see Screenshot");
        Reporter.log("<a target=\"_blank\" href="+screenshotPath+">Screenshot</a>");
        Reporter.log("<br>");
        Reporter.log("<br>");
        Reporter.log("<a target=\"_blank\" href="+screenshotPath+"><img src="+screenshotPath+" height=500 width=500></img></a>");
        //report.endTest(test);*/
        report.flush();
    }
    public void onTestSkipped(ITestResult arg0)
    {
        test.log(Status.SKIP, arg0.getName().toUpperCase()+" Skipped the test as the Run mode is NO");
      //  report.endTest(test);
        report.flush();
    }
    public void onTestStart(ITestResult arg0) {
        test = report.createTest(arg0.getName().toUpperCase());
    }
    public void onTestSuccess(ITestResult arg0) {
        test.log(Status.PASS, arg0.getName().toUpperCase()+" PASS");
       // report.endTest(test);
        report.flush();
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
    }
    public void onStart(ISuite arg0) {
        // TODO Auto-generated method stub
    }
}
