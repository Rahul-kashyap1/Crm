package Contact;

import org.openqa.selenium.By;

import Utility.Methods;
import Utility.RandomDataGenerator;

public class ContactPage extends Methods {

	public By contactLink = By.xpath("//a[text()='Contacts']");
	public By newContactLink = By.xpath("//a[text()='New Contact']");
	public By firstName = By.id("first_name");
	public By lastName = By.id("surname");
	public By saveButton = By.xpath("//form[@id='contactForm']//tbody//input[@value='Save']");
	public String firstNameValue;
	public String lastNameValue;

	public void createContact() {
		firstNameValue = RandomDataGenerator.GenerateRandomName(2);
		sendKeys(firstName, firstNameValue);
		lastNameValue = RandomDataGenerator.GenerateRandomName(2);
		sendKeys(lastName, lastNameValue);
		click(saveButton);

	}
}
