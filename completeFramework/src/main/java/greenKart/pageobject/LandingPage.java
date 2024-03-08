package greenKart.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import greenKart.Abstractcomponent.Abstractcomponents;

public class LandingPage extends Abstractcomponents {
	WebDriver driver;
	 
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement submit;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;


public CataloguePage loginApplication(String email, String password)
{
	userEmail.sendKeys(email);
	userPassword.sendKeys(password);
	submit.click();
	CataloguePage cataloguePage= new CataloguePage(driver);
	return cataloguePage;
}

    public void goTo()
    {
   driver.get("https://rahulshettyacademy.com/client");
}
    
    public String getErrorMessage()
    {
    	waitForWebElementtoAppear(errorMessage);
       return errorMessage.getText();
    	
    }
}



