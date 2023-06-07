package Resources;

import org.openqa.selenium.By;

import com.qa.ExtentReportListener.GenerateReport;

import Utility.Methods;
import Utility.RandomDataGenerator;

public class New_Resources extends Methods {

	public By resourcesLink = By.xpath("//a[@title='Resources']");
	public By newResources = By.xpath("//input[@value='New Resource']");
	public By dataCheckbox = By.xpath("//input[@value='D']");
	public By titleElement = By.id("title");
	public By resourceData = By.id("resource_d");
	public By saveBtn = By.xpath("//form[@id='CFForm_1']//input[@value='Save']");
	public String title;
	public String resource;
	public boolean flag = false;

	public void createNewResource(String operation) {

		switch (operation) {
		case "create_update":
			click(dataCheckbox);
			GenerateReport.Logger_click(reference, "Data checkbox");
			title = RandomDataGenerator.GenerateRandomName(2);
			clear(titleElement);
			sendKeys(titleElement, title);
			GenerateReport.Logger_EnterData(reference, "title", title);
			resource = RandomDataGenerator.GenerateRandomName(20);
			clear(resourceData);
			sendKeys(resourceData, resource);
			GenerateReport.Logger_EnterData(reference, "resource", resource);
			click(saveBtn);
			GenerateReport.Logger_click(reference, "Save Button");
			flag = isDisplayed(By.xpath("//a[text()='" + title + "']"));
			break;

		case "delete":
			click(By.xpath("//a[text()='" + title + "']//parent::td//following-sibling::td/a[2]"));
			GenerateReport.Logger_click(reference, "delete Icon");
			alertAccept();
			GenerateReport.Logger_click(reference, "Ok Button");
			flag = isDisplayed(By.xpath("//a[text()='" + title + "']//parent::td//following-sibling::td/a[2]"));
			break;
		default:
			break;
		}
	}

}
