package Pages;

import ExtentReportListener.ExtentReporterNG;
import ObjectRepository.Twitter_OR;
import Utils.Utilities;
import com.aventstack.extentreports.ExtentReports;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class twitLoginPage
{

    public static WebDriver driver;
    public twitLoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    ExtentReporterNG ExtentRp = new ExtentReporterNG();

    @FindBy(xpath =  Twitter_OR.TwitterSite )
    public WebElement TwitterSite;
    @FindBy(xpath =  Twitter_OR.twit_username )
    public WebElement  twit_username;
    @FindBy(xpath =  Twitter_OR.twit_password )
    public WebElement  twit_password;
    @FindBy(xpath =  Twitter_OR.twit_BtnLogin )
    public WebElement  twit_BtnLogin;
    @FindBy(xpath =  Twitter_OR.twit_BrowsePicLink )
    public WebElement  twit_BrowsePicLink;
    @FindBy(xpath =  Twitter_OR.twit_EditMediaApplyBtn )
    public WebElement  twit_EditMediaApplyBtn;
    @FindBy(xpath =  Twitter_OR.twit_HomeLink )
    public WebElement  twit_HomeLink;
    @FindBy(xpath =  Twitter_OR.twit_ExploreLink )
    public WebElement  twit_ExploreLink;
    @FindBy(xpath =  Twitter_OR.twit_NotificationsLink )
    public WebElement  twit_NotificationsLink;
    @FindBy(xpath =  Twitter_OR.twit_MessagesLink )
    public WebElement  twit_MessagesLink;
    @FindBy(xpath =  Twitter_OR.twit_BookmarksLink )
    public WebElement  twit_BookmarksLink;
    @FindBy(xpath =  Twitter_OR.twit_ListsLink )
    public WebElement  twit_ListsLink;
    @FindBy(xpath =  Twitter_OR.twit_ProfileLink )
    public WebElement  twit_ProfileLink;
    @FindBy(xpath =  Twitter_OR.twit_MoreLink )
    public WebElement  twit_MoreLink;
    @FindBy(xpath =  Twitter_OR.twit_EditProfileLink )
    public WebElement  twit_EditProfileLink;


    public void launchTwitterLoginPg(String uRL)
    {
        driver.get(uRL);
    }
    @Step("navigateToProfile - twitLoginPage")
    public void navigateToProfile()
    {
        ExtentRp.logger = ExtentRp.extent.createTest("Navigate To Profile Link Check");
        Utilities.highLightElement(driver,twit_ProfileLink);
        ExtentRp.logger.createNode("Profile Link is Present");
        Assert.assertTrue(twit_ProfileLink.isDisplayed());
        ExtentRp.logger.createNode("Profile Link is NOT Present");
        try
        {
            Assert.assertTrue(twit_ProfileLink.isDisplayed());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        twit_ProfileLink.click();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }
    @Step("loginToTwitterAccount - twitLoginPage with username : {0} and password : {1}")
    public void loginToTwitterAccount(String userName,String pwd)
    {
        ExtentRp.logger = ExtentRp.extent.createTest("To verify Google Logo");
        Utilities.highLightElement(driver,twit_username);
        twit_username.sendKeys(userName);
        Utilities.highLightElement(driver,twit_password);
        twit_password.sendKeys(pwd);
        Utilities.highLightElement(driver,twit_BtnLogin);
        twit_BtnLogin.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        ExtentRp.logger.createNode("loginToTwitterAccount");


    }
}
