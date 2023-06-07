package ui.tests.deals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtentReportListener.GenerateReport;
import com.qa.ExtentReportListener.TestListeners;
import Deals.DealsPage;
import Home.Home;
import Utility.Methods;
import loginPage.LoginPage;

public class QA_001_CreateNewDeal extends Methods {

	@Test
	public void createDeal() {

		reportInitialize();
		Home home = new Home();
		DealsPage deal = new DealsPage();
		try {
			switchToFrameByElement(home.frameElement);
			moveToElement(home.DealsLink);
			GenerateReport.Logger_click(reference, "Deal button");
			click(deal.newDeal);
			GenerateReport.Logger_click(reference, "New Deal");
			deal.createDeal();
			Assert.assertTrue(deal.flag);
			GenerateReport.Logger_TestPass(reference, "Deal is created successfully");
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
