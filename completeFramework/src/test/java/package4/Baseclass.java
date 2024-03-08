package package4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import greenKart.pageobject.LandingPage;



public class Baseclass {
    public WebDriver driver;
    public   LandingPage landingPage;
	
    public WebDriver initializeDriver() throws IOException
	{
	Properties prop= new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//greenKart//resources//GlobalData.properties");
	prop.load(fis);
	String browserName = prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome"))
	{
		driver =new ChromeDriver();
	
	}
	else if(browserName.equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
		}
	else if(browserName.equalsIgnoreCase("edge"))
	{
		driver =  new EdgeDriver();
	}
	
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;

}
    @BeforeMethod(alwaysRun=true)
    public LandingPage launchAplication() throws IOException
    {
    	driver= initializeDriver();
        landingPage= new LandingPage(driver);
    	landingPage.goTo();
    	return landingPage;
    }
    
    public  String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
	TakesScreenshot ts= (TakesScreenshot)driver;
    File source= ts.getScreenshotAs(OutputType.FILE);
	File file= new File(System.getProperty("user.dir")+ "//reports/" +testCaseName+ ".png");
	FileUtils.copyFile(source,file);
	return System.getProperty("user.dir")+ "//reports//" + testCaseName + ".png";
		// File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 //FileUtils.copyFile(src,new File("C:\\Users\\sabha\\screenshot.png"));//copy file from src to local machine

	}


	@AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}

}