package test;

import org.testng.annotations.Test;

import pages.Cart;
import pages.OpencloseBrowser;

public class Checkplp extends OpencloseBrowser {
Cart objcart;
@Test
public void plppage(){
	objcart=new Cart(driver);
	objcart.Addproduct();
}

}
