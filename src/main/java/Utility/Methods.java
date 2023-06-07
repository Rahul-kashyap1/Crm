package Utility;

import java.io.IOException;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.IExecutionListener;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtentReportListener.TestListeners;
import Base.Base;
import loginPage.LoginPage;

public class Methods extends Base {
	public String parentWindow;
	public boolean flag = false;
	public static ExtentTest reference;

	@BeforeMethod
	public void setUp() {
		try {
			initialization();
			launchBrowser();
		} catch (Exception e) {
			System.out.println("before method : setup");
			e.printStackTrace();
			Assert.fail();
		}

	}

	@BeforeSuite
	public void createNode(ITestContext context) {
		String name = context.getCurrentXmlTest().getSuite().getName();
		TestListeners.test = TestListeners.extent.createTest(name);

	}

	public void reportInitialize() {
		TestListeners test = new TestListeners();
		reference = test.testReference();
		LoginPage login = new LoginPage();
		login.login(reference);
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		closeBrowser();
	}

	@DataProvider(name = "loginData")
	public Object[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "//Resources//Data.xlsx";

		XLUtility xl = new XLUtility(path);
		int totalRow = xl.getRowCount("sheet1");
		int totalCol = xl.getCellCount("sheet1", totalRow);
		Object[][] a = new Object[totalRow - 1][totalCol];
		System.out.println("Row " + totalRow);
		System.out.println("Col " + totalCol);
		for (int row = 1; row <= totalRow - 1; row++) {
			for (int col = 0; col < totalCol; col++) {
				a[row - 1][col] = xl.getCellData("sheet1", row, col);
			}
		}
		System.out.println(Arrays.deepToString(a));

		return a;
	}

	public void click(By element) {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element))).click();
	}

	public void clear(By element) {
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element))).clear();

	}

	public void sendKeys(By element, String value) {
		wait.until(ExpectedConditions.presenceOfElementLocated(element)).sendKeys(value);
	}

	public void explicitWait(By element) {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
	}

	public void explicitWait(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void moveToElement(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(locator)).perform();
	}

	public void switchToFrameByElement(By locator) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public void switchToFrameByIndex(int index) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}

	public void switchToFrameByIdOrName(String value) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(value));
	}

	public void switchToParentFrame() {

		driver.switchTo().parentFrame();
	}

	public String getText(By locator) {
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator))).getText();
	}

	public String getAttributeValue(By locator) {
		return wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator))).getAttribute("value");
	}

	public void selectByVisibleText(By locator, String value) {
		Select s = new Select(driver.findElement(locator));
		s.selectByVisibleText(value);
	}

	public boolean isDisplayed(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public void alertAccept() {

		driver.switchTo().alert().accept();

	}

	public void alertDismiss() {

		driver.switchTo().alert().dismiss();
	}

	public boolean switchToalertIfPresent() {
		try {
			wait.until(ExpectedConditions.alertIsPresent());
			System.out.println("Alert is visible!");
			flag = true;
		} catch (Exception e) {
			System.out.println("Alert is not visible.");
			flag = false;
		}
		return flag;
	}

	public List<String> convertListOfWebelementToText(List<WebElement> list) {
		List<String> textList = list.stream().map((ele) -> ele.getText()).collect(Collectors.toList());
		return textList;
	}

	public void switchToWindowByTitleAndUrl(String titleOrUrl) {
		parentWindow = driver.getWindowHandle();
		System.out.println("parent window " + parentWindow);
		Set<String> listOfWindows = driver.getWindowHandles();
		Iterator<String> it = listOfWindows.iterator();
		while (it.hasNext()) {
			String childWindow = it.next();
			driver = driver.switchTo().window(childWindow);
			if (driver.getTitle().equals(titleOrUrl) || driver.getCurrentUrl().equals(titleOrUrl)) {
				break;
			}
		}
	}

	public void switchToSecondWindow() {
		parentWindow = driver.getWindowHandle();
		System.out.println("parent window " + parentWindow);
		Set<String> listOfWindows = driver.getWindowHandles();
		List<String> list = new ArrayList<>(listOfWindows);
		driver.switchTo().window(list.get(1));
	}

	public void switchToParentWindow(String id) {
		driver = driver.switchTo().window(id);
	}

	public void dragAndDrop(By source, By destination) {
		Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(source), driver.findElement(destination));
	}

	public void selectFromDropdown(By list1, String text) throws Exception {
		boolean flag = false;
		WebElement RequiredElement = null;
		List<WebElement> list = driver.findElements(list1);
		if (list.size() > 0) {
			for (WebElement element : list) {
				if (element.getText().equals(text)) {
					RequiredElement = element;
					flag = true;
					break;
				}
			}
			if (flag) {
				RequiredElement.click();
			} else {
				throw new Exception("Required String is not found");
			}
		} else {
			throw new Exception("There is no item inside dropdown");
		}
	}

	public void selectTodayCalenderDate() throws InterruptedException {
		LocalDate today = LocalDate.now();
		int month = today.getMonth().getValue();
		int day = today.getDayOfMonth();
		int year = today.getYear();
		Thread.sleep(2000);
		String monthYear = getText(
				By.xpath("//div[contains(@style,'position: absolute; display: block;')]/table/thead/tr[1]/td[2]"));
		String Actualyear = monthYear.split(",")[1].trim();
		while (year != Integer.parseInt(Actualyear)) {
			System.out.println(year + " " + Actualyear);
			if (year > Integer.parseInt(Actualyear)) {
				click(By.xpath(
						"//div[contains(@style,'position: absolute; display: block;')]/table/thead/tr[2]/td[4]"));
			} else {
				click(By.xpath(
						"//div[contains(@style,'position: absolute; display: block;')]/table/thead/tr[2]/td[2]"));
			}
			Actualyear = getText(
					By.xpath("//div[contains(@style,'position: absolute; display: block;')]/table/thead/tr[1]/td[2]"))
					.split(",")[1].trim();
		}
		String ActualMonth = getText(
				By.xpath("//div[contains(@style,'position: absolute; display: block;')]/table/thead/tr[1]/td[2]"))
				.split(",")[0];
		while (Month.valueOf(ActualMonth.toUpperCase()).getValue() != month) {
			if (Month.valueOf(ActualMonth.toUpperCase()).getValue() < month) {
				click(By.xpath(
						"//div[contains(@style,'position: absolute; display: block;')]/table/thead/tr[2]/td[4]"));
			} else {
				click(By.xpath(
						"//div[contains(@style,'position: absolute; display: block;')]/table/thead/tr[2]/td[2]"));
			}
			ActualMonth = getText(
					By.xpath("//div[contains(@style,'position: absolute; display: block;')]/table/thead/tr[1]/td[2]"))
					.split(",")[0].trim();
		}
		List<WebElement> date = driver.findElements(By.xpath(
				"//div[contains(@style,'position: absolute; display: block;')]/table/tbody/tr/td[@class='day' or contains(@class,'weekend') or contains(@class,'selected')] "));
		for (int i = 0; i < date.size(); i++) {
			System.out.println(date.get(i).getText());
			if (date.get(i).getText().equals(String.valueOf(day))) {
				date.get(i).click();
				break;
			}
		}
	}

	public boolean isListDisplayed(List<WebElement> list) {

		if (!list.isEmpty()) {
			flag = true;
		}
		return flag;
	}

	public boolean isElementPresentInPagination(List<WebElement> li, String value) {
		boolean enabled = true;
		try {
			while (enabled) {
				WebElement nextBtn = driver.findElement(By.id("example_next"));
				List<WebElement> list = driver.findElements(By.xpath("//table[@id='example']//tbody//tr/td[1]"));
				List<String> l = list.stream().map((m) -> m.getText()).collect(Collectors.toList());
				if (l.contains(value)) {
					flag = true;
				}
				if (nextBtn.isEnabled()) {
					nextBtn.click();
				}
			}
		} catch (Exception e) {
			enabled = false;
		}
		return flag;
	}

	public boolean isElementPresentInList(By list, String value) throws InterruptedException {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(list));
		Thread.sleep(5000);
		List<WebElement> l = driver.findElements(list);
		for (int i = 0; i < l.size(); i++) {
			String text = l.get(i).getText();
			System.out.println("list text " + text);
			if (text.equals(value)) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public void closeBrowser() {

		driver.close();
	}
}
