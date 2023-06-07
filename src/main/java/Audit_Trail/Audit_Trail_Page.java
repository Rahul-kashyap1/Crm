package Audit_Trail;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentTest;
import com.qa.ExtentReportListener.GenerateReport;

import Utility.Methods;

public class Audit_Trail_Page extends Methods {
	public By auditTrailLink = By.xpath("//a[@title='Audit Trail']");
	public By listOfusers = By.xpath("//table[@class='datacard']//tbody//tr//td[@class='datalistrow'][2]");
	public By auditSize = By.name("auditSize");
	public boolean result = false;
	public int sizeOfuser;

	public void verifyUser() {
		List<String> l = driver.findElements(listOfusers).stream().map((n) -> n.getText()).collect(Collectors.toList());
		System.out.println(l);
		result = driver.findElements(listOfusers).stream().allMatch((n) -> n.getText().trim().equals("Rahul kashyap".trim()));
		System.out.println("Result " + result);
	}

	public void verifyUserSizeInPage(ExtentTest reference) {
		selectByVisibleText(auditSize, "90");
		GenerateReport.Logger_click(reference, "90");
		sizeOfuser = driver.findElements(listOfusers).size();

	}
}
