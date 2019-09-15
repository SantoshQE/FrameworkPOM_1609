package reportsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class reportsStudy
{
    public static WebDriver driver = null;

    @BeforeTest
    public void launchBrowser()
    {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir").toString()+"/src/resources/ChromeDriver/Chrome76/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void navigateToGooglePage()
    {
        driver.get("http://www.google.com/");
        System.out.println(driver.getTitle().toString());

    }
    @AfterTest
    public void tearDown()
    {
        driver.close();
    }
}
