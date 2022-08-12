package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class HomePage extends base{  // inheriting the properties from base
	
	public WebDriver driver;
	private static Logger Log= LogManager.getLogger(base.class.getName());
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String Text) throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	  // two ways to access the methods of other class
	  //1. inheritance
	  //2. creating object to that class and invoke methods of it
	  LandingPage l = new LandingPage(driver);
	  LoginPage lp = l.getLogin(); // similar to driver.findelement(By.css());
	  lp.getmail().sendKeys(Username);
	  lp.getPassword().sendKeys(Password);
	   Log.info(Text);
	   lp.getLogin().click();
	  ForgotPassword fp = lp.forgotPassword();
	  fp.getmail().sendKeys("xxx");
	  fp.sendMeInstructions().click();
	}

	@DataProvider
	public Object[][] getData()
	{
		//rows stands for how many different data types test should run(ex.1- restricted user, non restricted user)
		// column stands for how many values per each test(ex.2-id,pwd, text)
		
		//array size is 5 then index 0,1,2,3,4
		Object[][] data = new Object[2][3];
		//0th row
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";
		//1st row
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456789";
		data[1][2] = "Non Restricted User"; 
		
		return data;
	}
	
	@AfterTest
	public void teardown()
	{
	   driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
