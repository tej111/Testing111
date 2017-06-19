package goodreads.signup.goodreads_qa;

import java.util.Map;

import org.junit.Assert;
import org.testng.annotations.Test;

import goodreads.signup.goodreads_qa.po.ApplicationPage;
import goodreads.signup.goodreads_qa.po.FinishRatingPage;
import goodreads.signup.goodreads_qa.po.HomePage;
import goodreads.signup.goodreads_qa.po.LogOutPage;
import goodreads.signup.goodreads_qa.po.RecommendationPage;
import goodreads.signup.goodreads_qa.po.SelectGeneres;
import goodreads.signup.goodreads_qa.po.SetReadingpage;
import goodreads.signup.goodreads_qa.po.SignInPage;

public class LoginTest extends BaseTest {
	private ApplicationPage applicationPage;
	private SetReadingpage setReadingPage;
	private SelectGeneres selectGeneres;
	private FinishRatingPage finishRatingPage;
	private RecommendationPage recommendationPage;
	private HomePage homePage;
	private LogOutPage logOutPage;
	private SignInPage signInPage;

	@Test(enabled = true)
	public void testLoginWithValidCredential() throws Exception {
		Map<String, Object> signUpData = pupulateUniqueData(xmlUtils.getXMLNodeValues("SignUpData"));
		driver.manage().deleteAllCookies();
		driver.get(homeUrl);
		String addEmail = "goodreads+" + System.currentTimeMillis() + "@yopmail.com";
		signUpData.put("email", addEmail);
		applicationPage = new ApplicationPage(driver);
		setReadingPage = applicationPage.signUpWithData(signUpData);
		selectGeneres = setReadingPage.setChallenge("2");
		finishRatingPage = selectGeneres.selectGenres("Art");
		recommendationPage = finishRatingPage.finishRating();
		homePage = recommendationPage.completeRegistration();
		Assert.assertEquals(driver.getTitle(), "Goodreads | Recent Updates");
		logOutPage = homePage.LogOutUser();
		signInPage = logOutPage.signInAgain();
		signInPage.login(addEmail, signUpData.get("password").toString());
		Assert.assertEquals(driver.getTitle(), "Goodreads | Recent Updates");
	}

	@Test(enabled = true)
	public void testLoginWithInValidCredential() throws Exception {
		Map<String, Object> signUpData = pupulateUniqueData(xmlUtils.getXMLNodeValues("SignUpData"));
		driver.manage().deleteAllCookies();
		driver.get(homeUrl);
		String addEmail = "goodreads+" + System.currentTimeMillis() + "@yopmail.com";
		signUpData.put("email", addEmail);
		applicationPage = new ApplicationPage(driver);
		setReadingPage = applicationPage.signUpWithData(signUpData);
		selectGeneres = setReadingPage.setChallenge("2");
		finishRatingPage = selectGeneres.selectGenres("Art");
		recommendationPage = finishRatingPage.finishRating();
		homePage = recommendationPage.completeRegistration();
		Assert.assertEquals(driver.getTitle(), "Goodreads | Recent Updates");
		logOutPage = homePage.LogOutUser();
		signInPage = logOutPage.signInAgain();
		signInPage.login(addEmail, "goods@123");
		Assert.assertTrue(signInPage.getErrorMsg().contains("recognize that email/password combination"));
	}
}
