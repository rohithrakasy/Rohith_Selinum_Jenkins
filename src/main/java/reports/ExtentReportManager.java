package reports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

	private static ExtentReports extent;

	public static ExtentReports getReportInstance() {

		if (extent == null) {
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

			String reportPath = "./reports/ExtentReport_" + timestamp + ".html";

			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);

			sparkReporter.config().setDocumentTitle("Selenium Automation Report");

			sparkReporter.config().setReportName("OrangeHRM Test Execution");

			extent.setSystemInfo("Project", "OrangeHRM Automation Framework");
			extent.setSystemInfo("Tester", "Rohith R");
			extent.setSystemInfo("Framework", "Selenium + TestNG");
		}

		return extent;
	}

}
