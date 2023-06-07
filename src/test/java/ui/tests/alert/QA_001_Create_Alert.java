package ui.tests.alert;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.ExtentReportListener.GenerateReport;

import Alert.New_Alert;
import Home.Home;
import Utility.Methods;

public class QA_001_Create_Alert extends Methods {

	@Test
	public void createAlert() throws InterruptedException {
		try {
			reportInitialize();
			Home home = new Home();
			switchToFrameByElement(home.frameElement);
			New_Alert alert = new New_Alert();
			click(alert.alertLink);
			GenerateReport.Logger_click(reference, "Alert");
			alert.createAlert("create", "Cases");
//			Assert.assertEquals(alert.record, "CASE");
			Assert.assertTrue(alert.record.contains("CASE"));
			GenerateReport.Logger_TestPass(reference, alert.record + " record is created successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
