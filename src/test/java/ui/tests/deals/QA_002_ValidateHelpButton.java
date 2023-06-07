package ui.tests.deals;

import org.openqa.selenium.By;
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

public class QA_002_ValidateHelpButton extends Methods {

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
			click(deal.identifierHelp);
			GenerateReport.Logger_click(reference, "Identifer Help");
			switchToSecondWindow();
			GenerateReport.Logger_Info(reference, "Switch to Help window");
			Thread.sleep(2000);
			Assert.assertEquals(getTitle(), "FreeCRM: Online Help");
			GenerateReport.Logger_TestPass(reference, "Both Title are same");
			closeBrowser();
			switchToParentWindow(parentWindow);
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
