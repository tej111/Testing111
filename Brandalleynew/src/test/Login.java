package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.Loginp;
import pages.OpencloseBrowser;

public class Login extends OpencloseBrowser{
	Loginp objLoginp;
	@Test
	public void Checklogin() throws InterruptedException{
	
		objLoginp=new Loginp(driver);
		objLoginp.Logged("hg.gh@yopmail.com", "qwerty@123");
		
		
	}

}
