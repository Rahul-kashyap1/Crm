package ui.tests.resources;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.ExtentReportListener.GenerateReport;

import Home.Home;
import Resources.New_Resources;
import Utility.Methods;

public class QA_001_CreateNewResource extends Methods {

	@Test
	public void createResource() {

		try {
			reportInitialize();
			New_Resources rs = new New_Resources();
			Home home = new Home();
			switchToFrameByElement(home.frameElement);
			click(rs.resourcesLink);
			GenerateReport.Logger_click(reference, "Resource");
			click(rs.newResources);
			GenerateReport.Logger_click(reference, "New Resources");
			rs.createNewResource("create_update");
			Assert.assertTrue(rs.flag);
			GenerateReport.Logger_TestPass(reference, "<b>" + rs.title + "'</b> Resource is created successfully");
			click(By.xpath("//a[text()='" + rs.title + "']//parent::td//following-sibling::td/a[1]"));
			rs.createNewResource("create_update");
			Assert.assertTrue(rs.flag);
			GenerateReport.Logger_TestPass(reference, "<b>" + rs.title + "'</b> Resource is updated successfully");
			rs.createNewResource("delete");
			Assert.assertFalse(rs.flag);
			GenerateReport.Logger_TestPass(reference, "<b>" + rs.title + "'</b> Resource is delete successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

	}

}
