package Package3;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import greenKart.pageobject.CartPage;
import greenKart.pageobject.CataloguePage;
import greenKart.pageobject.CheckoutPage;
import greenKart.pageobject.ConfirmationPage;
import greenKart.pageobject.OrderPage;
import package4.Baseclass;
    
public class Endtoend extends Baseclass{
	
	String productName ="ZARA COAT 3";
	@Test(dataProvider="getData",groups= {"purchase"})
	public void submitOrder(HashMap<String,String> input) throws IOException, InterruptedException
	{
    CataloguePage cataloguePage= landingPage.loginApplication(input.get("email"),input.get("password"));
    List<WebElement> products=	cataloguePage.getProductList();
	
	cataloguePage.addProductToCart(input.get("product"));
	CartPage cartPage	=cataloguePage.goToCart();
	
    Boolean match=cartPage.VerifyProductDisplay(input.get("product"));
    Assert.assertTrue(match);
     
      
    CheckoutPage checkoutPage=cartPage.goToCheckOut();
    checkoutPage.selectCountry("india");
    ConfirmationPage confirmationPage= checkoutPage.submitOrder();


    String confirmMessage  = confirmationPage.verifyConfiramationMessage();
    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));  
   		
	}
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistoryTest() throws InterruptedException
	{
		String productName ="ZARA COAT 3";
		CataloguePage cataloguePage= landingPage.loginApplication("anishakhan@gmail.com", "Anisha@123");
		OrderPage orderpage= cataloguePage.goToOredrsPage();
		Assert.assertTrue(orderpage.VerifyOrderDisplay(productName));
	}
	
	@DataProvider
	public Object getData()
	{
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("email", "anishakhan@gmail.com");
		map.put("password", "Anisha@123");
		map.put("product", "ZARA COAT 3");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("email", "minalara12@gmail.com");
		map1.put("password", "Minal@12");
		map1.put("product", "ADIDAS ORIGINAL");
		
		return new Object[][] {{map},{map1}};
				
	}
}






