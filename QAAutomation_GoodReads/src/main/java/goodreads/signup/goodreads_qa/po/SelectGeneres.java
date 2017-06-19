package goodreads.signup.goodreads_qa.po;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import goodreads.signup.goodreads_qa.utils.WaitTime;

public class SelectGeneres extends BasePage {

	@FindBy(xpath = "//label/input[2][contains(@name,'')]")
	private List<WebElement> genres;

	@FindBy(name = "commit")
	private WebElement contiNue;

	private WebDriver driver;

	public SelectGeneres(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public FinishRatingPage selectGenres(String str) {
		for (WebElement genere : genres) {
			if (genere.getAttribute("id").contains(str)) {
				genere.click();
			}
		}
		Reporter.log("<br>selectGenres::" + str, true);
		new WebDriverWait(driver, WaitTime.TOO_SHORT_TO).until(ExpectedConditions.elementToBeClickable(contiNue));
		contiNue.click();
		Reporter.log("<br>click Continue", true);
		return new FinishRatingPage(driver);
	}
}
