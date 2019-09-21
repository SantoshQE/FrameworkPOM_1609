package TestCases;

import Config.TestBase;
import Pages.twitLoginPage;
//import com.sun.org.glassfish.gmbal.Description;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TC4_twitLoginIE extends TestBase
{
    public static twitLoginPage twtLoginPg ;
    public static TestBase init ;

    @BeforeTest
    @Description("Call testbase class and open browser")
    public void launchBrowser()
    {
        TestBase.open_Browser("IE");
        twtLoginPg = new twitLoginPage(driver);
        twtLoginPg.launchTwitterLoginPg("https://twitter.com/login?lang=en");
    }
    @Test(priority = 1)
    @Description("Navigate to twitter profile page")
    public void twitterLogin() throws Throwable
    {
        twtLoginPg.loginToTwitterAccount("9967887510","Tcs@19831");
    }
    @Test(priority = 2)
    @Description("Navigate to twitter profile page")
    public void navigateToProfile() throws Throwable {
        twtLoginPg.navigateToProfile();
    }
    @AfterTest()
    public void tearDown()
    {
        driver.close();
    }
}
