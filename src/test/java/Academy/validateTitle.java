package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class validateTitle extends base{  // inheriting the properties from base
	
	
	public WebDriver driver;
	private static Logger Log= LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		Log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		Log.info("Navigated to Home Page");
	}
	
	@Test
	public void validateAppTitle() throws IOException
	{
		  
		  // two ways to access the methods of other class
		  //1. inheritance
		  //2. creating object to that class and invoke methods of it
		  LandingPage l = new LandingPage(driver);
		  //compare the text from the browser with actual text.-error..
		  
		  Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES123");
		  Log.info("Successfully validated text message");
	  
	}

	@AfterTest
	public void teardown()
	{
	   driver.close();
	}
	
	
	
	
	}
