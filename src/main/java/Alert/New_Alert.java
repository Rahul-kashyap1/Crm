package Alert;

import org.openqa.selenium.By;

import com.qa.ExtentReportListener.GenerateReport;

import Utility.Methods;

public class New_Alert extends Methods {
	public By alertLink = By.xpath("//a[@title='Alerts']");
	public By alert = By.name("alert_send_mode");
	public By globalAlertType = By.name("object_type");
	public By save = By.xpath("//form//input[@value='Save']");
	public By listOfRecordType = By.xpath("//table[@class='datacard']//tbody/tr/td[2]");
	public String record;

	public void createAlert(String operation, String type) throws InterruptedException {

		switch (operation) {
		case "create":
			selectByVisibleText(alert, "[S]pecific User (select below)");
			GenerateReport.Logger_Info(reference, "Selected value : [S]pecific User (select below)");
			selectByVisibleText(globalAlertType, type);
			GenerateReport.Logger_Info(reference, "Select value from global alert :" + type);
			click(save);
			GenerateReport.Logger_click(reference, "Save Button");
			int n = driver.findElements(listOfRecordType).size() - 1;
			explicitWait(driver.findElements(listOfRecordType).get(n));
//			Thread.sleep(6000);
			record = driver.findElements(listOfRecordType).get(n).getText();
			System.out.println("Record : " + record);
			break;

		default:
			break;
		}
	}
}
