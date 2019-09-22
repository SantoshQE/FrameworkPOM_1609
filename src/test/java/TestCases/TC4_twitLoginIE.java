package TestCases;

import Config.TestBase;
import Pages.twitLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import ExtentReportListener.ExtentManager;

public class TC4_twitLoginIE extends TestBase
{
    public static twitLoginPage twtLoginPg ;
   // public static TestBase init;

    @BeforeTest
    public void launchBrowser_IE()
    {
        //assignCategory("Regression");
      //  test.assignCategory("Regression");
        TestBase.open_Browser("IE");
        twtLoginPg = new twitLoginPage(driver);
        twtLoginPg.launchTwitterLoginPg("https://twitter.com/login?lang=en");
        //extentTest.assignCategory("Smoke");
    }
    @Test(priority = 1)
    public void twitterLogin_IE() throws Throwable
    {
     //   init.test.assignCategory("Regression");
        twtLoginPg.loginToTwitterAccount("9967887510","Tcs@19831");
        extentTest.assignCategory("Smoke");
    }
    @Test(priority = 2)
    public void navigateToProfile_IE() throws Throwable {
     //   init.test.assignCategory("Regression");
        extentTest.assignCategory("Smoke");
        twtLoginPg.navigateToProfile();

    }
    @AfterTest()
    public void tearDown_IE()
    {
        driver.close();
        //extentTest.assignCategory("Smoke");
    }
}
