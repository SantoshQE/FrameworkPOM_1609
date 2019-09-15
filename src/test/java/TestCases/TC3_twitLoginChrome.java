package TestCases;

import Config.TestBase;
import Pages.phpTravelsLoginPage;
import Pages.twitLoginPage;
import Utils.TestUtil;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TC3_twitLoginChrome  extends TestBase
{
    public static twitLoginPage twtLoginPg ;
    public static TestBase init ;

    @BeforeTest(description = "--TestNGDescription :-- Launch web browser")
    public void launchBrowser()
    {
        TestBase.open_Browser("Chrome");
        twtLoginPg = new twitLoginPage(driver);
        twtLoginPg.launchTwitterLoginPg("https://twitter.com/login?lang=en");
    }
    @Test(priority = 1,description ="--TestNGDescription :-- Log into twitter account" )
    public void twitterLogin() throws Throwable
    {
        twtLoginPg.loginToTwitterAccount("9967887510","Tcs@1983");
    }
    @Test(priority = 2,description ="--TestNGDescription :-- Navigate to twitter profile page" )
    public void navigateToProfile() throws Throwable {
        twtLoginPg.navigateToProfile();
       // TestUtil.takeScreenshotAtEndOfTest();
    }
    @AfterTest()
    public void tearDown()
    {
        driver.close();
    }
}
