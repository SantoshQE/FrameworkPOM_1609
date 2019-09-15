package TestCases;

import Config.TestBase;
import Pages.phpTravelsLoginPage;
import com.sun.org.glassfish.gmbal.Description;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC2_phpTravelLoginIE extends TestBase
{
    public static phpTravelsLoginPage phpLoginPg ;
    public static TestBase init ;
/*    public TC1_phpTravelLogin()
    {

    }*/
    @BeforeTest
    @Description("Call testbase class and open browser")
    public void launchBrowser()
    {
        TestBase.open_Browser("IE");
        phpLoginPg = new phpTravelsLoginPage(driver);
        phpLoginPg.launchPhpTravelSite("https://www.phptravels.net/admin");
    }
    @Test(priority = 1)
    @Description("Verify successful login to phpTravels using Admin Credentials")
    public void phpTravelAdminLogin() throws Throwable {
        phpLoginPg.phpTravelsAdminLogin("admin@phptravels.com","demoadmin");
        phpLoginPg.phpTravelsAdminLoginSucessCheck();
    }

    @AfterTest()
    public void tearDown()
    {
       driver.close();
    }

}
