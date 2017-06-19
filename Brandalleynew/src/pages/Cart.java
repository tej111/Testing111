package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Cart {
	private WebDriver driver;
	By categ=By.linkText("WOMEN");
	By SaleB=By.linkText("Reiss Separates");
	By buy=By.id("prodid_1176942");
	
	Loginp objLoginp;
	public Cart(WebDriver driver){
		/*this.driver=driver;*/
		this.driver=driver;
	}
	
	public void Category(){
		objLoginp=new Loginp(driver);
		try {
			objLoginp.Logged("hg.gh@yopmail.com", "qwerty@123");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(categ).click();
	}

public void Plp(){
	Cart sa=new Cart(driver);
	sa.Category();
	driver.findElement(SaleB).click();
}
public void Addproduct(){
	Cart sd=new Cart(driver);
	sd.Plp();
	driver.findElement(buy).click();
}
}
