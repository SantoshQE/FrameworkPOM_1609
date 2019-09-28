package ExtentReportListener;

import Listeners.CustomListeners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager extends CustomListeners {

    public static ExtentReports extent;
    public WebDriver driver;
    public ExtentHtmlReporter htmlReporter;
    public ExtentTest extentTestbase;
    //public static ExtentTest extentTestbase;

    public static ExtentReports getInstance()
    {
        if(extent==null)
        {
            extent = new ExtentReports();
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/CustomReports/QEExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("ReportName", "QE Automation Test Report");
            extent.setSystemInfo("HostName", "ABN Test");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("UserName", "Santosh Pandhare");
            htmlReporter.config().setDocumentTitle("QE Test Report");
            // Name of the report
            htmlReporter.config().setReportName("QE Test Report");
            // Dark Theme
          //  htmlReporter.config().setTheme(Theme.STANDARD);
        }
        return extent;
    }

}
