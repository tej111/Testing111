package goodreads.signup.goodreads_qa;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import goodreads.signup.goodreads_qa.utils.XMLUtils;

public abstract class BaseTest {
	private enum DriverType {
		Firefox, IE, Chrome
	}

	public WebDriver driver;
	public XMLUtils xmlUtils;
	public String homeUrl;

	@BeforeClass
	@Parameters({ "driverType", "url" })
	public void beforeMainClass(String driverType, String url) throws URISyntaxException {
		if (DriverType.Firefox.toString().equals(driverType)) {
			String pathToDriver = new File(this.getClass().getResource("/geckodriver.exe").toURI()).toString();
			System.setProperty("webdriver.firefox.marionette", pathToDriver);
			driver = new FirefoxDriver();
		} else if (DriverType.IE.toString().equals(driverType)) {
			String pathToDriver = new File(this.getClass().getResource("/IEDriverServer.exe").toURI()).toString();
			System.setProperty("webdriver.ie.driver", pathToDriver);
			driver = new InternetExplorerDriver();
		} else if (DriverType.Chrome.toString().equals(driverType)) {
			String pathToDriver = new File(this.getClass().getResource("/chromedriver.exe").toURI()).toString();
			System.out.println("pathToDriver" + pathToDriver);
			System.setProperty("webdriver.chrome.driver", pathToDriver);
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("disable-infobars");
			driver = new ChromeDriver(ops);
		} else {
			String pathToDriver = new File(this.getClass().getResource("/geckodriver.exe").toURI()).toString();
			System.setProperty("webdriver.firefox.marionette", pathToDriver);
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String pathToFile = new File(this.getClass().getResource("/test_data.xml").toURI()).toString();
		xmlUtils = new XMLUtils(pathToFile);
		Reporter.log("<br>Opening url::" + url, true);
		homeUrl = url;

	}

	@AfterClass
	public void afterMainClass() {

	}

	@BeforeTest
	public void beforeMainTest() {

	}

	@AfterTest
	public void afterMainTest() {

	}

	@BeforeMethod
	public void beforeMethod(Method method) {

		Reporter.log("<br>****************************************************************************************");
		Reporter.log("<br>****************************************************************************************");
		Reporter.log("<br>$$$$$$$$$$$$$$$$$$$$$              " + method.getName() + "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		Reporter.log("<br>****************************************************************************************");
		Reporter.log("<br>****************************************************************************************");
	}

	@AfterMethod
	public void afterMethod(Method method) {
		Reporter.log(
				"<br>XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");
		Reporter.log("<br>X");
		Reporter.log("<br>X");
		Reporter.log("<br>X");

	}

	public Map<String, Object> pupulateUniqueData(Map<String, Object> data) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String uid = "";
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			char c = alphabet.charAt(random.nextInt(26));
			uid += c;
		}
		for (Entry<String, Object> entry : data.entrySet()) {
			if (entry.getValue().toString().contains("UNIQUE")) {
				data.put(entry.getKey(), entry.getValue().toString().replaceAll("UNIQUE", uid));
			} else {
				data.put(entry.getKey(), entry.getValue().toString());
			}
		}
		return data;
	}

}
