package Base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	FileInputStream fs;
	public static Properties prop;
	public static WebDriver driver;
	public static WebDriverWait wait;

	public void initialization() {

		String path = System.getProperty("user.dir") + "\\src\\main\\resources\\Config.properties";

		try {
			fs = new FileInputStream(path);
			prop = new Properties();
			prop.load(fs);
		} catch (Exception e) {
			System.out.println("Not readable");
		}

	}

	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("please select valid browser");
			break;
		}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	}

}
