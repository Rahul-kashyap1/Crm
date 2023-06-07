package Messages;

import org.openqa.selenium.By;
import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtentReportListener.GenerateReport;
import Utility.Methods;
import Utility.RandomDataGenerator;

public class MessagePage extends Methods {
	public By newMessage = By.xpath("//input[@value='New Message']");
	public By subject = By.id("subject");
	public By message = By.id("msg");
	public By post = By.xpath("//input[@value='Post']");
	public By listOfSubject = By.xpath("//table[@class='datacard']/tbody//td[@class='datalistrow'][1]/a");
	public boolean result;
	public String RandomSubject;
	public String RandomMessage;

	public void createNewMessage(ExtentTest reference, String operation) throws InterruptedException {
		switch (operation) {
		case "create":
			click(newMessage);
			GenerateReport.Logger_click(reference, "New Message");
			RandomSubject = RandomDataGenerator.GenerateRandomName(10);
			sendKeys(subject, RandomSubject);
			GenerateReport.Logger_EnterData(reference, "Subject", RandomSubject);
			RandomMessage = RandomDataGenerator.GenerateRandomName(20);
			sendKeys(message, RandomMessage);
			GenerateReport.Logger_EnterData(reference, "Message", RandomMessage);
			click(post);
			GenerateReport.Logger_click(reference, "Post");
			break;
		case "update":
			click(By.xpath("//a[text()='" + RandomSubject + "']//parent::td//following-sibling::td/a[1]"));
			GenerateReport.Logger_click(reference, "<b>" + RandomSubject + "</b>");
			RandomSubject = RandomDataGenerator.GenerateRandomName(10);
			clear(subject);
			sendKeys(subject, RandomSubject);
			GenerateReport.Logger_EnterData(reference, "Subject", RandomSubject);
			RandomMessage = RandomDataGenerator.GenerateRandomName(20);
			clear(message);
			sendKeys(message, RandomMessage);
			GenerateReport.Logger_EnterData(reference, "Message", RandomMessage);
			click(post);
			GenerateReport.Logger_click(reference, "Post");
			break;

		case "delete":
			click(By.xpath("//a[text()='" + RandomSubject + "']//parent::td//following-sibling::td/a[2]"));
			GenerateReport.Logger_Info(reference, "Clicked on delete button of " + RandomSubject);
			switchToalertIfPresent();
			Thread.sleep(2000);
			alertAccept();
			result = isDisplayed(By.xpath("//a[text()='" + RandomSubject + "']//parent::td//following-sibling::td/a[2]"));
			break;
		default:
			break;
		}

	}
}
