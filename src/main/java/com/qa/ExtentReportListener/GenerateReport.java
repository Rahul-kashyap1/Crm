package com.qa.ExtentReportListener;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GenerateReport {

	public static ExtentTest Logger_createDataFrom(ExtentTest Node_Type, String app, String value) {
		Node_Type.log(Status.INFO, "created <b>'" + value + "'</b> from <b>'" + app + "'</b> app.");
		return Node_Type;

	}

	/*
	 * [TestMethod] [Description("logger for creating data")]
	 */

	public static ExtentTest LoggerPASS_createDatafrom(ExtentTest Node_Type, String app, String value) {
		Node_Type.log(Status.PASS, "Successfully created  <b>'" + value + "'</b> from <b>'" + app + "'</b> app.");
		return Node_Type;

	}

	/*
	 * [TestMethod] [Description("logger for creating data")]
	 */

	public static ExtentTest LoggerFAIL_createDatafrom(ExtentTest Node_Type, String app, String value) {
		Node_Type.log(Status.FAIL, "Unable to Create <b>'" + value + "'</b> from <b>'" + app + "'</b> app.");
		return Node_Type;

	}

	/*
	 * [TestMethod] [Description("logger for Updating data")]
	 */

	public static ExtentTest Logger_UpdateData(ExtentTest Node_Type, String app, String value) {
		Node_Type.log(Status.INFO, "Updated <b>'" + value + "'</b> in <b>'" + app + "'</b> app.");
		return Node_Type;

	}

	/*
	 * [TestMethod] [Description("logger for creating data")]
	 */

	public static ExtentTest LoggerPASS_UpdateData(ExtentTest Node_Type, String app, String value) {
		Node_Type.log(Status.PASS, "Succesfully Updated <b>'" + value + "'</b> from <b>'" + app + "'</b> app.");
		return Node_Type;

	}

	/*
	 * [TestMethod] [Description("logger for creating data")]
	 */

	public static ExtentTest LoggerFAIL_UpdateData(ExtentTest Node_Type, String app, String value) {
		Node_Type.log(Status.FAIL, "Unable to Update <b>'" + value + "'</b> from <b>'" + app + "'</b> app.");
		return Node_Type;

	}

	/*
	 * [TestMethod] [Description("logger for launching app")]
	 */

	public static ExtentTest Logger_LauchApp(ExtentTest Node_Type, String app) {
		Node_Type.log(Status.INFO, "Launched <b>'" + app + "'</b> app.");
		return Node_Type;

	}

	/*
	 * [TestMethod] [Description("logger for creating data")]
	 */

	public static ExtentTest LoggerPASS_LauchApp(ExtentTest Node_Type, String app) {
		Node_Type.log(Status.PASS, "Succesfully Launched <b>'" + app + "'</b> app.");
		return Node_Type;

	}

	public static ExtentTest Logger_Info(ExtentTest Node_Type, String info) {
		Node_Type.log(Status.INFO, info);
		return Node_Type;

	}
	/*
	 * [TestMethod] [Description("logger for creating data")]
	 */

	public static ExtentTest LoggerFAIL_LauchApp(ExtentTest Node_Type, String app) {
		Node_Type.log(Status.FAIL, "Unable to Launch <b>'" + app + "'</b> app.");
		return Node_Type;

	}

	/*
	 * [TestMethod] [Description("logger for Entering data")]
	 */

	public static ExtentTest Logger_EnterData(ExtentTest Node_Type, String locator, String value) {
		Node_Type.log(Status.INFO, "Entered text <b>'" + value + "'</b> in " + locator);
		return Node_Type;
	}

	public static ExtentTest Logger_File_Chosen(ExtentTest Node_Type, String path) {

		Path p = Paths.get(path);
		String fileName = p.getFileName().toString();
		Node_Type.log(Status.INFO, " <b>'" + fileName + "'</b>  file is chosen successfully");
		return Node_Type;

	}

	/*
	 * [TestMethod] [Description("logger for clicking a button")]
	 */

	public static ExtentTest Logger_click(ExtentTest Node_Type, String locator) {
		Node_Type.log(Status.INFO, "clicked on <b>'" + locator + " '</b>");
		return Node_Type;

	}

	/*
	 * [TestMethod] [Description("logger for selecting data")]
	 */

	public static ExtentTest Logger_SelectData(ExtentTest Node_Type, String data, String locator) {
		Node_Type.log(Status.INFO, "Selected <b>'" + data + "'</b> from <b>" + locator + "</b>");
		return Node_Type;

	}

	/*
	 * [TestMethod] [Description("logger for exact value of data")]
	 */

	public static ExtentTest Logger_PrintData(ExtentTest Node_Type, String data, String locator) {
		Node_Type.log(Status.INFO, "<b>" + locator + "</b> is <b>'" + data + "'</b>");
		return Node_Type;

	}

	/*
	 * [TestMethod] [Description("logger for landing data")]
	 */

	public static ExtentTest Logger_landingPage(ExtentTest Node_Type, String page) {
		Node_Type.log(Status.INFO, "<b>'" + page + "'</b> page Appeared succsessfully");
		return Node_Type;

	}

	/*
	 * [TestMethod] [Description("logger for failure exception in catch block")]
	 */

	public static ExtentTest Logger_ExceptionFail(ExtentTest Node_Type, Exception e) {
		Node_Type.log(Status.FAIL, "Exception " + e);
		return Node_Type;
	}

	/*
	 * [TestMethod] [Description("logger for failure exception in catch block")]
	 */

	public static ExtentTest Logger_TestFail(ExtentTest Node_Type, String error) {
		Node_Type.log(Status.FAIL, "Test Error " + "<b>" + error + "</b>");
		return Node_Type;

	}

	public static ExtentTest Logger_Warning(ExtentTest Node_Type, String error) {
		Node_Type.log(Status.WARNING, "Test Error " + "<b>" + error + "</b>");
		return Node_Type;

	}

	public static ExtentTest Logger_AssertionFail(ExtentTest Node_Type, AssertionError e) {
		Node_Type.log(Status.FAIL, "Exception " + e);
		return Node_Type;
	}

	public static ExtentTest Logger_TestPass(ExtentTest Node_Type, String message) {
		Node_Type.log(Status.PASS, message);
		return Node_Type;

	}
}
