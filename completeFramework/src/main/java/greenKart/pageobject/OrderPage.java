package greenKart.pageobject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import greenKart.Abstractcomponent.Abstractcomponents;

public class OrderPage extends Abstractcomponents {
	WebDriver driver;
	 
	@FindBy(css=".totalRow button")
	 WebElement checkoutEle;

	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> ProductNames;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public Boolean VerifyOrderDisplay(String productName)
	{
		Boolean match =ProductNames.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}
	
    public CheckoutPage goToCheckOut()
    {
    	JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        checkoutEle.click();
    	CheckoutPage checkoutPage= new CheckoutPage(driver);
    	return checkoutPage;
    }
}
