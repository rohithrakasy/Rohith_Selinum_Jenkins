package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import reports.ExtentReportManager;
import reports.ExtentTestManager;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

	ExtentReports extent = ExtentReportManager.getReportInstance();
	

	@Override
	public void onTestStart(ITestResult result) {

		ExtentTest test = extent.createTest(result.getName());
		
		ExtentTestManager.setTest(test);

		test.info("Test started: " + result.getName());

//		System.out.println("Test started: "+ result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

//		ExtentTest test = extent.createTest(result.getName());
		
		ExtentTestManager.getTest().pass("Test Passed: " + result.getName());

//		System.out.println("Test Passed: "+ result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		ExtentTestManager.getTest().fail("Test Failed: " + result.getName());

		ExtentTestManager.getTest().fail(result.getThrowable());
//		System.out.println("Test Failed: "+ result.getName());

//		BaseTest basetest = (BaseTest) result.getInstance();

		String screenshotPath = ScreenshotUtils.captureScreenshot(result.getName());

		ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);
		
		ExtentTestManager.unload();

//		System.out.println("Screenshot Captured: "+ screenshotPath);

	}

	@Override
	public void onTestSkipped(ITestResult result) {

	    ExtentTestManager.getTest()
	            .skip("Test Skipped: " + result.getName());

	    ExtentTestManager.unload();
	}
	
	@Override
	public void onFinish(ITestContext context) {

		extent.flush();

	}

}
