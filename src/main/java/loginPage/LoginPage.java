package loginPage;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtentReportListener.GenerateReport;

import Base.Base;
import Utility.Methods;

public class LoginPage extends Methods {

	public By username = By.name("username");
	public By password = By.name("password");
	public By loginButton = By.xpath("//input[@type='submit']");

	public void login(ExtentTest reference) {
		GenerateReport.LoggerPASS_LauchApp(reference, prop.getProperty("browser") + " browser");
		sendKeys(username, prop.getProperty("username"));
		GenerateReport.Logger_EnterData(reference, "Email TextBox", prop.getProperty("username"));
		sendKeys(password, prop.getProperty("password"));
		GenerateReport.Logger_EnterData(reference, "Password TextBox", prop.getProperty("password"));

		click(loginButton);
		GenerateReport.Logger_click(reference, "Submit Button");
	}
}
