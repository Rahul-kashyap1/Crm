package com.qa.ExtentReportListener;

import java.io.File;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Base.Base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListeners implements ITestListener {

//	public static WebDriver driver ;
	// This reference is used by test cases (classes) to create test steps in Report
	public static ExtentReports extent = ExtentManager.getInstance();
	public static ExtentTest test;
	public static ExtentTest childTest;
	public static int success=0;
	public static int failure=0;
	// Making report to be free from multiple threads that could be formed during
	// parallel execution
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
	        
	        
//		test = extent.createTest(result.getTestClass().getName() + " -> " + result.getMethod().getMethodName());
//		extentTest.set(test);
		childTest = test.createNode(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String logText = "<b> Test Case '" + result.getMethod().getMethodName() + "' is Successful </b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		childTest.log(Status.PASS, m);
//		test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShot.getBase64()).build());
		success++;
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String exceptionMessage = Arrays.deepToString(result.getThrowable().getStackTrace());
		String title = Base.driver.getTitle();
		System.out.println(title);
		String scrn = getScreenhot(title);

		childTest.fail("<details><summary><b><font color = red>" + "Exception occured (Click Here)"
				+ "</font></b></summary>" + exceptionMessage.replaceAll(",", "<br>") + "</details> \n");

		String logText = "<b> Test Case '" + result.getMethod().getMethodName() + "' is Failed </b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		childTest.log(Status.FAIL, m);
//		test.addScreenCaptureFromPath(scrn);
		childTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(scrn).build());
		failure++;
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String logText = "<b> Test Case  " + result.getMethod().getMethodName() + " is Skipped </b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.BLUE);
		childTest.log(Status.SKIP, m);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
//		System.out.println("Success: " + TestListeners.success);
//		System.out.println("Failure: " + TestListeners.failure);
//		ExtentManager.extent.setSystemInfo("<b>Pass</b>", String.valueOf(TestListeners.success));
//		ExtentManager.extent.setSystemInfo("<b>Fail</b>", String.valueOf(TestListeners.failure));
		if (extent != null) {
			extent.flush();
		}
	}

	public ExtentTest testReference() {
		return childTest;
	}

	public static String getScreenhot(String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) Base.driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "//reports//Screenshots//" + screenshotName + ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}