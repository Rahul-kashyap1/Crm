package Home;

import org.openqa.selenium.By;

import Utility.Methods;

public class Home extends Methods {

	public By frameElement = By.xpath("//frame[@name='mainpanel']");
	public By DealsLink = By.xpath("//a[@title='Deals']");
	public By productsTab = By.xpath("//div[@id='leftMenuContainer']//a[text()='Products']");
	public By DocLink = By.xpath("//a[@title='Docs']");
	public By casesLink = By.xpath("//a[@title='Cases']");
	public By salesTarget = By.xpath("//a[@title='Sales Targets']");
	public By messageLink = By.xpath("//a[@title='Messages']");
	public By noCompanyLoadedLink = By.linkText("no company loaded");
	public By secondWindowText=By.xpath("//tbody//tr[2]/td/p");
}
