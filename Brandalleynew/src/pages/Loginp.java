package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginp{
	
	public WebDriver driver;
	By Reg=By.id("showLoginBox");
	By Mail=By.id("login-email");
	By Pass=By.id("pass");
	By log_click=By.id("send2");
	
	public Loginp(WebDriver driver){
		this.driver=driver;
		
		
	}
	public void Clickregister(){
	driver.findElement(Reg).click();
	
	}
	public void Emailf(String Email){
		driver.findElement(Mail).sendKeys(Email);
		
	}
	public void Passwordf (String Password){
		driver.findElement(Pass).sendKeys(Password);
	}
	public void Loginclick(){
		driver.findElement(log_click).click();
	}
	public void Logged(String Email,String Password) throws InterruptedException{
	this.Clickregister();
	this.Emailf(Email);
	this.Passwordf(Password);
	this.Loginclick();
	Thread.sleep(5000);
	}
}