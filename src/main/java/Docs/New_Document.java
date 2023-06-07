package Docs;

import org.openqa.selenium.By;
import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtentReportListener.GenerateReport;

import Utility.Methods;
import Utility.RandomDataGenerator;
import Home.Home;

public class New_Document extends Methods {

	public By newDocument = By.xpath("//a[@title='New Document']");
	public By title = By.id("title");
	public By filechosen = By.name("file");
	public By save = By.xpath("//form[@id='docForm']//input[@value='Save']");
	public boolean flag = false;
	public String docTitle;

	public void create_document(ExtentTest reference) throws InterruptedException {
		Home home = new Home();
		docTitle = RandomDataGenerator.GenerateRandomName(2);
		sendKeys(title, docTitle);
		GenerateReport.Logger_EnterData(reference, "Document Title", docTitle);
		sendKeys(filechosen, System.getProperty("user.dir") + "//Resources//dummy.PNG");
		GenerateReport.Logger_File_Chosen(reference, System.getProperty("user.dir") + "//Resources//dummy.PNG");
		click(save);
		GenerateReport.Logger_click(reference, "Save button");
		click(home.DocLink);
		GenerateReport.Logger_click(reference, "Document Button");
		System.out.println(getText(By.xpath("//a[contains(text(),'" + docTitle + "')]")));
		flag = isDisplayed(By.xpath("//a[text()='" + docTitle + "']"));
		System.out.println(flag);

	}
}
