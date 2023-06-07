package ui.tests.login;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtentReportListener.TestListeners;

import Utility.Methods;
import loginPage.LoginPage;

public class LoginTest extends Methods {

	@Test(dataProvider = "loginData", dataProviderClass = Methods.class)
	public void loginPageTest(String s, String u, String p) {
		LoginPage login = new LoginPage();
		TestListeners test = new TestListeners();
		ExtentTest reference = test.testReference();
		try {

			System.out.println(s + " " + u + " " + p);
//			login.login(reference);
//			sendKeys(login.username, prop.getProperty("username"));
//			reference.log(reference.getStatus(), "Enter username");
//			sendKeys(login.password, prop.getProperty("password"));
//			reference.log(reference.getStatus(), "Enter password");
//			click(login.loginButton);
//			reference.log(reference.getStatus(), "Click on login button");
//			Assert.assertEquals(getTitle(), "CRMPRO");
			
//			login.login(reference);
			sendKeys(login.username, u);
			reference.log(reference.getStatus(), "Enter username");
			sendKeys(login.password,p);
			reference.log(reference.getStatus(), "Enter password");
			click(login.loginButton);
			reference.log(reference.getStatus(), "Click on login button");
			Assert.assertEquals(getTitle(), "CRMPRO");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}
	}

}
