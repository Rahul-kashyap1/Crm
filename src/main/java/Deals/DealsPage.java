package Deals;

import org.openqa.selenium.By;

import Utility.Methods;
import Utility.RandomDataGenerator;

public class DealsPage extends Methods {

	public By newDeal = By.xpath("//a[@title='New Deal']");
	public By title = By.id("title");
	public By company = By.name("client_lookup");
	public By amount = By.id("amount");
	public By type = By.name("type");
	public By source = By.name("source");
	public By saveButton = By.xpath("//form[@id='prospectForm']//tbody//input[@value='Save']");
	public By identifierHelp = By.xpath("//input[@name='identifier']//following-sibling::input");
	public String titleValue;
	public String companyValue;
	public String amountValue;
	public boolean flag;

	public void createDeal() {

		titleValue = RandomDataGenerator.GenerateRandomName(2);
		sendKeys(title, titleValue);
		companyValue = RandomDataGenerator.GenerateRandomName(2);
		sendKeys(company, companyValue);
		amountValue = RandomDataGenerator.GenerateRandomNumber(5);
		selectByVisibleText(type, "New");
		selectByVisibleText(source, "Existing Customer");
		click(saveButton);
		flag = isDisplayed(By.xpath("//*[@id=\"vSummary\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[3]/td[2]/a[text()='" + companyValue + "']"));
		System.out.println(flag);
		System.out.println(getText(By.xpath("//*[@id=\"vSummary\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[3]/td[2]/a[text()='" + companyValue + "']")));

	}
}
