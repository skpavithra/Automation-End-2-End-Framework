package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
	public WebDriver driver;
	public ForgotPassword(WebDriver driver)
	{
		this.driver = driver;
	}
    
	
	By email = By.cssSelector("[id='user_email']");
	By sendMeInstructions = By.cssSelector("[type='submit']");
	

    public WebElement getmail()
    {
      return driver.findElement(email);
    
    }

    public WebElement sendMeInstructions()
    {
      return driver.findElement(sendMeInstructions);
    
    }
}
