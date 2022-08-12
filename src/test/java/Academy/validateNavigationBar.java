package Academy;

import java.io.IOException;

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

//adding logs

public class validateNavigationBar extends base{  // inheriting the properties from base
	
	public WebDriver driver;
	private static Logger Log= LogManager.getLogger(base.class.getName());
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	
	@Test
	public void basePageNavigation() throws IOException
	{
	  
	  
	  // two ways to access the methods of other class
	  //1. inheritance
	  //2. creating object to that class and invoke methods of it
	  LandingPage l = new LandingPage(driver);
	  //compare the text from the browser with actual text.-error..
	  
	   Assert.assertTrue(l.getNavigationBar().isDisplayed());
	    Log.info("Navigation Bar is displayed");
	}

	@AfterTest
	public void teardown()
	{
	   driver.close();
	}
	
	}
