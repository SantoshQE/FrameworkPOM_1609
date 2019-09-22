package TestCases;

import Config.TestBase;
import Pages.phpTravelsLoginPage;
import Pages.twitLoginPage;
import Utils.TestUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TC3_twitLoginChrome  extends TestBase
{
    public static twitLoginPage twtLoginPg ;
    public static TestBase init ;

    @BeforeTest
    public void launchBrowser_Chrome()
    {
       // test.assignCategory("Smoke");
        TestBase.open_Browser("Chrome");
        twtLoginPg = new twitLoginPage(driver);
        twtLoginPg.launchTwitterLoginPg("https://twitter.com/login?lang=en");
        //extentTest.assignCategory("Regression");
    }
    @Test(priority = 1,description ="--TestNGDescription :-- Log into twitter account" )
    public void twitterLogin_Chrome() throws Throwable
    {
        extentTest.assignCategory("Regression");
       // init.test.assignCategory("Smoke");
        twtLoginPg.loginToTwitterAccount("9967887510","Tcs@1983");

    }
    @Test(priority = 2,description ="--TestNGDescription :-- Navigate to twitter profile page" )
    public void navigateToProfile_Chrome() throws Throwable {
       // init.test.assignCategory("Smoke");
        extentTest.assignCategory("Regression");
        twtLoginPg.navigateToProfile();

       // TestUtil.takeScreenshotAtEndOfTest();
    }
    @AfterTest()
    public void tearDown_Chrome()
    {
        //init.test.assignCategory("Smoke");
        driver.close();
       // extentTest.assignCategory("Regression");
    }
}
