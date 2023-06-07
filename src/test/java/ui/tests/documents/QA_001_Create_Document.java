package ui.tests.documents;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtentReportListener.GenerateReport;
import com.qa.ExtentReportListener.TestListeners;
import Docs.New_Document;
import Home.Home;
import Utility.Methods;
import loginPage.LoginPage;

public class QA_001_Create_Document extends Methods {

	@Test
	public void create_Document() {
		try {
			TestListeners test = new TestListeners();
			ExtentTest reference = test.testReference();
			LoginPage login = new LoginPage();
			login.login(reference);
			Home home = new Home();
			New_Document doc = new New_Document();
			switchToFrameByElement(home.frameElement);
			moveToElement(home.DocLink);
			GenerateReport.Logger_click(reference, "Document button");
			click(doc.newDocument);
			GenerateReport.Logger_click(reference, "New Document button");
			doc.create_document(reference);
			Assert.assertTrue(doc.flag);
			GenerateReport.Logger_TestPass(reference, "<b>'" + doc.docTitle + "'</b> document is created successfully");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
