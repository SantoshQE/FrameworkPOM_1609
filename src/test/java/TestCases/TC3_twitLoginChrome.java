package TestCases;

import Config.TestBase;
import ExtentReportListener.ExtentManager;
import Pages.twitLoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.CustomListeners;

//@Listeners(CustomListeners.class)
public class TC3_twitLoginChrome  extends TestBase
{
    public static twitLoginPage twtLoginPg ;
    public static TestBase init ;
    public static TestBase extentTestbase;
    public static ExtentTest test;
    public static ExtentTest parentTest;
    public static ExtentTest childTest;

    @BeforeTest
    public void launchBrowser_Chrome()
    {
        TestBase.open_Browser("Chrome");
        twtLoginPg = new twitLoginPage(driver);
        twtLoginPg.launchTwitterLoginPg("https://twitter.com/login?lang=en");
       // extentTestbase.assignCategory("Regression");
      //  init = new TestBase();
    }
    @Test(priority = 1,description ="--TestNGDescription :-- Log into twitter account" )
    public void twitterLogin_Chrome() throws Throwable
    {
       // init.test.assignCategory("Smoke");
//        extentTest.assignCategory("Regression");
        //parentTest = report.createTest("Parent Test --twitterLogin_Chrome");
        //childTest = ExtentManager.getTest().createNode("Log into twitter application");
        //childTest = parentTest.createNode("Log into twitter application");
        //childTest.log(Status.PASS, MarkupHelper.createLabel("Twitter login successful", ExtentColor.BLUE));
        twtLoginPg.loginToTwitterAccount("9967887510","Tcs@1983");
       //extent = ExtentManager.getTest().assignCategory();
        ExtentManager.getTest().assignCategory("PositiveTests");
    }
    @Test(priority = 2,description ="--TestNGDescription :-- Navigate to twitter profile page" )
    public void navigateToProfile_Chrome() throws Throwable {
       // init.test.assignCategory("Smoke");
     //   extentTest.assignCategory("Regression");
        twtLoginPg.navigateToProfile();
       // parentTest = report.createTest("Parent Test --navigateToProfile");
      //  childTest = parentTest.createNode("Navigate To profile Link");
       // childTest.log(Status.PASS, MarkupHelper.createLabel("Profile page navigate", ExtentColor.BLUE));
        ExtentManager.getTest().assignCategory("PositiveTests");
    }
    @AfterTest()
    public void tearDown_Chrome()
    {
        //init.test.assignCategory("Smoke");
        driver.close();
       // extentTest.assignCategory("Regression");
    }
}
