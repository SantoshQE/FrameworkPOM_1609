package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class checkAutoit
{
    public static WebDriver driver;
    public static void main(String args[]) throws IOException
    {
        runWinAuthCheck();
    }
    public static void runWinAuthCheck() throws IOException {
        for(int i=1;i<11;i++)
        {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/resources/ChromeDriver/Chrome76/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            Runtime.getRuntime().exec(System.getProperty("user.dir")+"/src/resources/AutoitExe/Login_WinAuthentication.exe", null, new File(System.getProperty("user.dir")+"/src/resources/AutoitExe/"));
            driver.get("http://192.168.0.8:8081");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.close();
        }
    }
}
