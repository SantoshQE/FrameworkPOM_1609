package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC2_MultiBrowser
{
 /*   public WebDriver driver;

    @Parameters("browser")
    @BeforeClass

    // Passing Browser parameter from TestNG xml
    public void beforeTest(String browser)
    {
        if(browser.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir").toString()+"/src/resources/ChromeDriver/Chrome76/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        }
        else if (browser.equalsIgnoreCase("IE"))
        {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir").toString()+"/src/resources/IEDriver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
            DesiredCapabilities DCap = new DesiredCapabilities();
            DCap.setCapability(CapabilityType.BROWSER_NAME, "IE");
            DCap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        }
        // Doesn't the browser type, lauch the Website
        driver.get("http://www.store.demoqa.com");
    }
    // Once Before method is completed, Test method will start
    @Test
    public void login() throws InterruptedException
    {
     *//*   driver.findElement(By.xpath(".//*[@id='account']/a")).click();
        driver.findElement(By.id("log")).sendKeys("testuser_1");
        driver.findElement(By.id("pwd")).sendKeys("Test@123");
        driver.findElement(By.id("login")).click();*//*

     driver.findElement(By.xpath("//*[@id='noo-site']//li/a[@href='http://shop.demoqa.com/my-account/']")).click();


    }

    @AfterClass
    public void afterTest()
    {
        driver.quit();
    }*/
}
