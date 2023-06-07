package ui.tests.home;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.ExtentReportListener.GenerateReport;

import Home.Home;
import Utility.Methods;

public class QA_001_ValidateNoCompanyLoadedButton extends Methods {

	@Test
	public void validateButton() {
		try {
			reportInitialize();
			Home h = new Home();
			switchToFrameByElement(h.frameElement);
			GenerateReport.Logger_Info(reference, "Switched to Frame");
			click(h.noCompanyLoadedLink);
			GenerateReport.Logger_click(reference, "No company loaded link");
			switchToSecondWindow();
			GenerateReport.Logger_Info(reference, "Switched to second window");
			getText(h.secondWindowText);
			System.out.println(getText(h.secondWindowText));
			closeBrowser();
			switchToParentWindow(parentWindow);
			GenerateReport.Logger_Info(reference, "Switched to parent window");
			switchToFrameByElement(h.frameElement);
			click(h.casesLink);
			GenerateReport.Logger_click(reference, "Message link");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
