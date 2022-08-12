package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
    
	
	By signin = By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector(".text-center");
	By navBar = By.cssSelector(".navbar.navbar-default.navbar-static-top");
    
   
    
    public LoginPage getLogin()
    {
      driver.findElement(signin).click();
      LoginPage lp = new LoginPage(driver);
      return lp;
    
    }

    public WebElement getTitle()
    {
      return driver.findElement(title);
    
    }

    public WebElement getNavigationBar()
    {
      return driver.findElement(navBar);
    
    }


}
