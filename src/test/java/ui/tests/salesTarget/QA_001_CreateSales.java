package ui.tests.salesTarget;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.ExtentReportListener.GenerateReport;

import Home.Home;
import SalesTarget.SalesPage;
import Utility.Methods;

public class QA_001_CreateSales extends Methods {

	@Test
	public void createSales() {
		try {
			reportInitialize();
			Home home = new Home();
			switchToFrameByElement(home.frameElement);
			click(home.salesTarget);
			GenerateReport.Logger_click(reference, "Sales Target");
			SalesPage s = new SalesPage();
			click(s.newTarget);
			GenerateReport.Logger_click(reference, "New Target");
			s.createTarget(reference, "create");
			Assert.assertTrue(s.flag);
			GenerateReport.Logger_TestPass(reference, "<b>'" + s.data + "'</b> target is created successfully");
			s.createTarget(reference, "update");
			Assert.assertTrue(s.flag);
			GenerateReport.Logger_TestPass(reference, "<b>'" + s.data + "'</b> target is updated successfully");
			s.createTarget(reference, "delete");
			Assert.assertFalse(s.flag);
			GenerateReport.Logger_TestPass(reference, "<b>'" + s.data + "'</b> target is deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
