package greenKart.pageobject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import greenKart.Abstractcomponent.Abstractcomponents;

public class CartPage extends Abstractcomponents {
	WebDriver driver;
	 
	@FindBy(css=".totalRow button")
	 WebElement checkoutEle;

	@FindBy(css=".cartSection h3")
	private List<WebElement> cartProducts;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public Boolean VerifyProductDisplay(String productName)
	{
		Boolean match =cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
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
