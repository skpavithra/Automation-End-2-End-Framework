package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

public WebDriver driver;
public Properties prop;
public WebDriver initializeDriver() throws IOException
{
  prop = new Properties();
  FileInputStream fis = new FileInputStream("C:\\Users\\skpav\\selenium training\\E2EProject\\src\\main\\java\\resources\\data.properties");
	
  prop.load(fis);
  String browserName = prop.getProperty("browser");
  System.out.println(browserName);
	
  if(browserName.equals("chrome"))
    {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\skpav\\Documents\\chromedriver.exe");
      driver = new ChromeDriver();
    }
  else if (browserName.equals("firefox"))
    {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\skpav\\Documents\\geckodriver.exe");
      driver = new FirefoxDriver();
	}
  else if (browserName.equals("Edge"))
    {
	  System.setProperty("webdriver.msedge.driver", "C:\\Users\\skpav\\Documents\\msedgedriver.exe");
      driver = new EdgeDriver();
	}
  
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  return driver;
}

public String getScreenShotPath(String testMethodName, WebDriver driver) throws IOException
{
   TakesScreenshot ts = (TakesScreenshot) driver;
   File source = ts.getScreenshotAs(OutputType.FILE);
   String destinationFile = System.getProperty("user.dir")+"\\reports\\"+ testMethodName +".png";
   FileUtils.copyFile(source, new File(destinationFile));
   return destinationFile;
}


}
