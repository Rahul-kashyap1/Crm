package ui.tests.auditTrail;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.ExtentReportListener.GenerateReport;

import Audit_Trail.Audit_Trail_Page;
import Home.Home;
import Utility.Methods;

public class QA_002_verifyNoOfUserInPage extends Methods {

	@Test
	public void verify_size() {
		try {
			reportInitialize();
			Home home = new Home();
			switchToFrameByElement(home.frameElement);
			Audit_Trail_Page a = new Audit_Trail_Page();
			click(a.auditTrailLink);
			GenerateReport.Logger_click(reference, "Audit Trail");
			a.verifyUserSizeInPage(reference);
			Assert.assertTrue(a.sizeOfuser == 30);
			GenerateReport.Logger_TestPass(reference, "size is 90 which was expected");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
