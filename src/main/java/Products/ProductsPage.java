package Products;

import org.openqa.selenium.By;

import Utility.Methods;
import Utility.RandomDataGenerator;

public class ProductsPage extends Methods {

	public By newProduct = By.xpath("//input[@value='New Product']");
	public By name = By.id("name");
	public By description = By.name("description");
	public By saveButton = By.xpath("(//form[@id='productForm']//input[@value='Save'])[1]");
	public By editButton = By.xpath("//input[@value='Edit']");
	public String productName;
	public String descriptionName;
	public boolean productDisplay;

	public boolean create_Product(String operation) {

		switch (operation) {
		case "create":
			productName = RandomDataGenerator.GenerateRandomName(2);
			clear(name);
			sendKeys(name, productName);
			descriptionName = RandomDataGenerator.GenerateRandomName(5);
			clear(description);
			sendKeys(description, descriptionName);
			click(saveButton);
			productDisplay = isDisplayed(By.xpath("//td[contains(text(),'" + descriptionName + "')]"));
			System.out.println(getText(By.xpath("//td[contains(text(),'" + descriptionName + "')]")));
			System.out.println(descriptionName);
			break;

		case "delete":
			click(By.xpath("//a[text()='" + productName + "']//parent::td//following-sibling::td/a[3]"));
			alertAccept();
			productDisplay = isDisplayed(By.xpath("//a[text()='" + productName + "']//parent::td//following-sibling::td/a[3]"));

		default:
			break;
		}
		return productDisplay;

	}
}
