package TestCases;

import Config.TestBase;
import ObjectRepository.Phptravels_OR;
import Pages.phpTravelsLoginPage;
//import com.sun.org.glassfish.gmbal.Description;
import com.aventstack.extentreports.ExtentTest;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TC1_phpTravelLoginChrome extends TestBase
{
    public static phpTravelsLoginPage phpLoginPg ;
    public static TestBase init ;
    private ExtentTest extentTestbase;


    /*    public TC1_phpTravelLogin()
        {

        }*/
    @BeforeTest
    @Description("Call testbase class and open browser")
    public void launchBrowser()
    {
        TestBase.open_Browser("Chrome");
        phpLoginPg = new phpTravelsLoginPage(driver);
        phpLoginPg.launchPhpTravelSite("https://www.phptravels.net/admin");
        extentTestbase.assignCategory("PhpTravelTest");
    }
    @Test(priority = 1)
    @Description("Verify successful login to phpTravels using Admin Credentials")
    public void phpTravelAdminLogin() throws Throwable {
        phpLoginPg.phpTravelsAdminLogin("admin@phptravels.com","demoadmin");
        phpLoginPg.phpTravelsAdminLoginSucessCheck();
        extentTestbase.assignCategory("PhpTravelTest");
    }

    @AfterTest()
    public void tearDown()
    {
       driver.close();
    }

}
