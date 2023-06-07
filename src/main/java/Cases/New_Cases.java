package Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.devtools.v110.cast.Cast;

import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtentReportListener.GenerateReport;

import Utility.Methods;
import Utility.RandomDataGenerator;

public class New_Cases extends Methods {
	public By newCases = By.xpath("//a[@title='New Case']");
	public By caseNo = By.name("sequence");
	public By title = By.id("title");
	public By status = By.name("status");
	public By description = By.id("description");
	public By saveButton = By.xpath("(//form[@id='caseForm']//input[@value='Save'])[1]");
	public boolean flag = false;
	public String caseValue;
	public String caseTitle;

	public void createCase(ExtentTest reference, String t, String des) {
		caseValue = getAttributeValue(caseNo);
//		caseTitle = RandomDataGenerator.GenerateRandomName(2);
		sendKeys(title, t);
//		GenerateReport.Logger_EnterData(reference, "title", caseTitle);
		selectByVisibleText(status, "Awaiting input");
		sendKeys(description, des);
		click(saveButton);
		GenerateReport.Logger_click(reference, "Save Button");

	}
}
