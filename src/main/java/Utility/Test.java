package Utility;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
	static String osName = System.getProperty("os.name");
	static String destination = null;

	public static void main(String[] args) throws Exception {

		// Location of the generated Extent report file
		String reportFilePath = "C:\\Users\\kashyap.rahul\\eclipse-workspace\\CRMPro\\reports\\AutomationReport_Mon_May_22_11_20_02_IST_2023.html";

		// Open the report file in a web browser
		openReportInBrowser(reportFilePath);

	}

	public static String getScreenhot() {

		try {
			TakesScreenshot ts = (TakesScreenshot) Base.driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			String destination = System.getProperty("user.dir") + "//reports//Screenshots//" + " screenshotName" + ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	private static void openReportInBrowser(String filePath) throws Exception {
		try {
			Base.driver.get(filePath);
			Thread.sleep(5000);
			getScreenhot();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
