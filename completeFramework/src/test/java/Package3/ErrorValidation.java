package Package3;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import greenKart.pageobject.CartPage;
import greenKart.pageobject.CataloguePage;
import greenKart.pageobject.CheckoutPage;
import greenKart.pageobject.ConfirmationPage;
import greenKart.pageobject.LandingPage;
import package4.Baseclass;
    
public class ErrorValidation extends Baseclass{
	
	@Test(groups= {"errorhandling"})
	public void loginErrorValidation()
	{
	String productName ="ZARA COAT 3";
	CataloguePage cataloguePage= landingPage.loginApplication("anishakan1@gmail.com", "Aisha@153");
	Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
    }
	
	@Test
	public void productErrorValidation() throws IOException, InterruptedException
	{
	String productName ="ZARA COAT 3";
	CataloguePage cataloguePage= landingPage.loginApplication("anishakhan@gmail.com", "Anisha@123");
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	List<WebElement> products=	cataloguePage.getProductList();
	
	cataloguePage.addProductToCart(productName);
	CartPage cartPage	=cataloguePage.goToCart();
	
    Boolean match=cartPage.VerifyProductDisplay("ZARA COAT 33");
    Assert.assertFalse(match);
    
	
	
	
	
    
     
      
 
   		
	}
}







