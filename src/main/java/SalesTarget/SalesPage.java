package SalesTarget;

import org.openqa.selenium.By;
import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtentReportListener.GenerateReport;
import Utility.Methods;
import Utility.RandomDataGenerator;

public class SalesPage extends Methods {

	public By newTarget = By.xpath("//input[@value='New Target']");
	public By type = By.name("target_type_id");
	public By description = By.id("target_text");
	public By target = By.id("target");
	public By timeFrame = By.id("target_days");
	public By savebutton = By.xpath("//form[@id='targetForm']//input[@value='Save']");
	public String data;

	public void createTarget(ExtentTest reference, String operation) throws Exception {
		switch (operation) {
		case "create":
			selectByVisibleText(type, "Quantity of closed deals");
			GenerateReport.Logger_Info(reference, "Value selected from type dropdown : Quantity of closed deals");
			data = RandomDataGenerator.GenerateRandomName(3);
			sendKeys(description, data);
			GenerateReport.Logger_EnterData(reference, "description", data);
			sendKeys(target, data);
			GenerateReport.Logger_EnterData(reference, "target", data);
			sendKeys(timeFrame, data);
			GenerateReport.Logger_EnterData(reference, "time frame", data);
			click(savebutton);
			GenerateReport.Logger_click(reference, "Save button");
			System.out.println(switchToalertIfPresent());
			if (switchToalertIfPresent()) {
				alertAccept();
				String n = RandomDataGenerator.GenerateRandomNumber(2);
				clear(target);
				sendKeys(target, n);
				GenerateReport.Logger_EnterData(reference, "target", n);
				clear(timeFrame);
				sendKeys(timeFrame, n);
				GenerateReport.Logger_EnterData(reference, "time frame", n);
				click(savebutton);
				GenerateReport.Logger_click(reference, "Save button");
				if (switchToalertIfPresent()) {
					throw new Exception("Alert is displaying which should have not been displayed");
				} else {
					flag = isDisplayed(By.xpath("//td//a[text()='" + data + "']"));
					System.out.println("flag " + flag);
					Thread.sleep(3000);
				}
			} else {
				throw new Exception("Alert is not present");
			}
			break;

		case "update":
			click(By.xpath("//a[text()='" + data + "']//parent::td//following-sibling::td/a[1]"));
			GenerateReport.Logger_Info(reference, "Clicked on Edit button of <b>'" + data + "'</b>");
			data = RandomDataGenerator.GenerateRandomName(3);
			clear(description);
			sendKeys(description, data);
			GenerateReport.Logger_EnterData(reference, "description", data);
			String n = RandomDataGenerator.GenerateRandomNumber(2);
			clear(target);
			sendKeys(target, n);
			GenerateReport.Logger_EnterData(reference, "target", n);
			clear(timeFrame);
			sendKeys(timeFrame, n);
			GenerateReport.Logger_EnterData(reference, "time frame", n);
			click(savebutton);
			flag = isDisplayed(By.xpath("//td//a[text()='" + data + "']"));
			break;

		case "delete":
			click(By.xpath("//a[text()='" + data + "']//parent::td//following-sibling::td/a[2]"));
			GenerateReport.Logger_Info(reference, "Clicked on Delete button of <b>'" + data + "'</b>");
			if (switchToalertIfPresent()) {
				alertAccept();
			} else {
				throw new Exception("Alert is not present");
			}
			flag = isDisplayed(By.xpath("//td//a[text()='" + data + "']"));
			System.out.println("delete flag " + flag);
			break;
		default:
			break;
		}

	}
}
