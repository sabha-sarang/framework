package greenKart.Abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import greenKart.pageobject.CartPage;
import greenKart.pageobject.OrderPage;

public class Abstractcomponents {
	WebDriver driver;
	
	
    public Abstractcomponents(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
		
	}
    
   @FindBy(css="[routerlink*='cart']")
   WebElement cartHeader ;

   @FindBy(css="[routerlink*='myorders']")
   WebElement orderHeader ;
	public void waitForElementtoAppear(By findBy)
    {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	
	 wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
	
	public void waitForWebElementtoAppear(WebElement findBy)
    {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	
	 wait.until(ExpectedConditions.visibilityOf(findBy));
    }
	
	public CartPage goToCart()
	{
		cartHeader.click();
		CartPage cartPage= new CartPage(driver);
        return cartPage;
	}
	
	public OrderPage goToOredrsPage()
	{
		orderHeader.click();
		OrderPage orderpage= new OrderPage(driver);
        return orderpage;
	}
	
	
	public void waitForElementtoDisappear(WebElement ele) throws InterruptedException
	{
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
    Thread.sleep(1000);
	}
}
