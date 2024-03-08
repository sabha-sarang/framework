package greenKart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import greenKart.Abstractcomponent.Abstractcomponents;

public class ConfirmationPage extends Abstractcomponents {
	WebDriver driver;
	 
	@FindBy(css=".hero-primary")
	 WebElement confirmationMessage;
	
	public ConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
    public String verifyConfiramationMessage()
    {
    return confirmationMessage.getText();	
    }
}
