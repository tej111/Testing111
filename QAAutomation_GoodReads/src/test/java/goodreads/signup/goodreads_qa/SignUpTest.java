package goodreads.signup.goodreads_qa;

import java.util.Map;

import org.junit.Assert;
import org.testng.annotations.Test;

import goodreads.signup.goodreads_qa.po.ApplicationPage;
import goodreads.signup.goodreads_qa.po.FinishRatingPage;
import goodreads.signup.goodreads_qa.po.RecommendationPage;
import goodreads.signup.goodreads_qa.po.SelectGeneres;
import goodreads.signup.goodreads_qa.po.SetReadingpage;

public class SignUpTest extends BaseTest {
	private ApplicationPage applicationPage;
	private SetReadingpage setReadingPage;
	private SelectGeneres selectGeneres;
	private FinishRatingPage finishRatingPage;
	private RecommendationPage recommendationPage;

	@Test(enabled = true)
	public void testSignUpWithValidCredential() throws Exception {
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
		recommendationPage.completeRegistration();
		Assert.assertEquals(driver.getTitle(), "Goodreads | Recent Updates");
	}

	@Test(enabled = true)
	public void testSignUpWithInValidCredential() throws Exception {
		Map<String, Object> signUpData = pupulateUniqueData(xmlUtils.getXMLNodeValues("SignUpData"));
		driver.manage().deleteAllCookies();
		driver.get(homeUrl);
		String addEmail = "goodreads+" + System.currentTimeMillis() + "yopmail.com";
		signUpData.put("email", addEmail);
		applicationPage = new ApplicationPage(driver);
		setReadingPage = applicationPage.signUpWithData(signUpData);
		Assert.assertTrue(driver.getTitle().contains("Share Book Recommendations With Your Friends"));
	}
}
