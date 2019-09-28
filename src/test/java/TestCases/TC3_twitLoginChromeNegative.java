package TestCases;

import Config.TestBase;
import Pages.twitLoginPage;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC3_twitLoginChromeNegative extends TestBase
{
    public static twitLoginPage twtLoginPg ;
    public static TestBase init ;
    private ExtentTest extentTestbase;


/*    public TC3_twitLoginChromeNegative(WebDriver driver) {
        this.driver = driver;
    }*/

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

       // init.test.assignCategory("Smoke");
        twtLoginPg.loginToTwitterAccount("9967887510","Tcs@19831");
        //extentTestbase.assignCategory("Regression");


    }
    @Test(priority = 2,description ="--TestNGDescription :-- Navigate to twitter profile page" )
    public void navigateToProfile_Chrome() throws Throwable {
       // init.test.assignCategory("Smoke");

        twtLoginPg.navigateToProfile();
        //extentTest.createNode("navigateToProfile_Chrome_node1");
       // extentTest.createNode("navigateToProfile_Chrome_node2");
      //  extentTestbase.createNode(extentTestbase.getStatus().toString());
     //   extentTestbase.assignCategory("Regression");

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
