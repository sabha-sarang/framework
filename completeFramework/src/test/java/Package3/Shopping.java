package Package3;

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

import greenKart.pageobject.LandingPage;



 public class Shopping {
		
	   public static void main(String[] args)
	   {
		   WebDriver driver;
     driver =new ChromeDriver();
	driver.manage().window().maximize();
	String productName ="ZARA COAT 3";
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://rahulshettyacademy.com/client");
 
	driver.findElement(By.id("userEmail")).sendKeys("anishakhan@gmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("Anisha@123");
	driver.findElement(By.id("login")).click();
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
List<WebElement> products =driver.findElements(By.cssSelector(".mb-3"));

 WebElement prod = products.stream().filter(product->
   product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
  //tag b we have the result ,find first means finding the first zara coat value bcz it may many product with same 
  //name so v take first got value ignoring other
	//filter oly frst item orelse rtrn null
prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));//#id css

wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

//write common css or xpth tht selects items in cart
List <WebElement> cartProducts =driver.findElements(By.cssSelector(".cartSection h3"));//parentcss &childtag

Boolean match =cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
Assert.assertTrue(match);

JavascriptExecutor js =(JavascriptExecutor) driver;
 js.executeScript("window.scrollBy(0,600)");
driver.findElement(By.cssSelector(".totalRow button")).click();

Actions a =new Actions(driver);
a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();

WebElement element= driver.findElement(By.cssSelector(".action__submit")); //plce order
JavascriptExecutor jse =(JavascriptExecutor) driver;
jse.executeScript("arguments[0].click()", element);


String confirmMessage  = driver.findElement(By.cssSelector(".hero-primary")).getText(); 
Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));  
driver.close();
		
		
}
 }
 


