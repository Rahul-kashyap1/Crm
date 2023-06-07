package ui.tests.auditTrail;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.ExtentReportListener.GenerateReport;

import Audit_Trail.Audit_Trail_Page;
import Home.Home;
import Utility.Methods;

public class QA_001_VerifyUserName extends Methods {

	@Test
	public void verifyUserName() {
		try {
			reportInitialize();
			Home home = new Home();
			switchToFrameByElement(home.frameElement);
			Audit_Trail_Page a = new Audit_Trail_Page();
			click(a.auditTrailLink);
			GenerateReport.Logger_click(reference, "Audit Trail");
			a.verifyUser();
			Assert.assertTrue(a.result);
			GenerateReport.Logger_TestPass(reference, "All users are same");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
