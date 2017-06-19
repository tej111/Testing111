package goodreads.signup.goodreads_qa.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends BasePage {
	@FindBy(xpath = "//img[@class='circularIcon circularIcon--border']")
	private WebElement rightMenu;
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOut;

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LogOutPage LogOutUser() {
		rightMenu.click();
		signOut.click();
		Reporter.log("<br>LogOutUser", true);
		return new LogOutPage(driver);
	}
}
