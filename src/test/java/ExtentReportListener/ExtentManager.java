package ExtentReportListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.awt.*;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance()
    {
        if(extent==null)
        {
            extent = new ExtentReports();
            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/CustomReports/QEExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);

        }
        return extent;
    }


}
