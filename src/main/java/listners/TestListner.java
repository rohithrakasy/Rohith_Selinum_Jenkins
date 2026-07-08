package listners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import reports.ExtentReportManager;
import utils.ScreenshotUtils;

public class TestListner implements ITestListener {
	
	ExtentReports extent = ExtentReportManager.getReportInstance();
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		test =extent.createTest(result.getName());
		
		test.info("Test started: "+ result.getName());
		
//		System.out.println("Test started: "+ result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.pass("Test Passed: "+ result.getName());
		
//		System.out.println("Test Passed: "+ result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		test.fail("Test Failed: "+ result.getName());
		
		test.fail(result.getThrowable());
//		System.out.println("Test Failed: "+ result.getName());
		
		BaseTest basetest = (BaseTest) result.getInstance();
		
		String screenshotPath= ScreenshotUtils.captureScreenshot(basetest.getDriver(), result.getName());
		
		test.addScreenCaptureFromPath(screenshotPath);
		
//		System.out.println("Screenshot Captured: "+ screenshotPath);

	}
	
	@Override
	public void onFinish(ITestContext  context) {
		
		extent.flush();
		
	}
	
	
	
	

}
