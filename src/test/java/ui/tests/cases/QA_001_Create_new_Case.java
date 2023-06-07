package ui.tests.cases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.ExtentReportListener.GenerateReport;
import Cases.New_Cases;
import Home.Home;
import Utility.Methods;

public class QA_001_Create_new_Case extends Methods {

	@Test(dataProvider = "loginData", dataProviderClass = Methods.class)
	public void create_case(String title,String description) {

		try {
			reportInitialize();
			Home home = new Home();
			New_Cases c = new New_Cases();
			switchToFrameByElement(home.frameElement);
			moveToElement(home.casesLink);
			GenerateReport.Logger_click(reference, "Case ");
			click(c.newCases);
			GenerateReport.Logger_click(reference, "New case ");
			c.createCase(reference,title,description);
			click(home.casesLink);
			GenerateReport.Logger_click(reference, "Case Link");
			Assert.assertTrue(isDisplayed(By.xpath("//a[text()='" + c.caseValue + "']//parent::td//following-sibling::td//a[text()='" + title + "']")));
			GenerateReport.Logger_TestPass(reference, c.caseValue + " case is created successfully");
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
