package pages;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class OpencloseBrowser {
	public WebDriver driver;
	@BeforeTest
	public void Openbrowser(){
	File file=new File("C:\\library\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	ChromeOptions opt=new ChromeOptions();
	opt.addArguments("disable-infobars");
	driver=new ChromeDriver(opt);
	driver.get("https://www.brandalley.co.uk");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	@AfterTest
	public void Closebrowser(){
		//driver.close();
	}
}
