package ui.tests.contact;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtentReportListener.TestListeners;

import Contact.ContactPage;
import Home.Home;
import Utility.Methods;
import loginPage.LoginPage;

public class QA_001_CreateNewContact extends Methods {

	@BeforeMethod
	public void setUp() {
		initialization();
		launchBrowser();
		

	}

	@Test
	public void loginPageTest() {

		TestListeners test = new TestListeners();
		ExtentTest reference = test.testReference();
		LoginPage login = new LoginPage();
		login.login(reference);
		Home home = new Home();
		ContactPage contact = new ContactPage();

		try {
			Thread.sleep(2000);
			switchToFrameByElement(home.frameElement);
			moveToElement(contact.contactLink);
			reference.log(reference.getStatus(), "Click on Contact Link");
			click(contact.newContactLink);
			reference.log(reference.getStatus(), "Click on New Contact Link");
			Thread.sleep(5000);
			contact.createContact();
			reference.log(reference.getStatus(), "Contact is created successfully");
			System.out.println(contact.firstNameValue);
			System.out.println(getText(contact.firstName));
			Assert.assertEquals(contact.firstNameValue, getText(contact.firstName));

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
