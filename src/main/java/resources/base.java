package resources;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initiaslazeDriver() throws IOException{
		prop = new Properties();
		FileInputStream path = new FileInputStream("/Users/stask/LoginAparavi/src/main/java/resources/data.properties");
		prop.load(path);
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals ("chrome"))  {
			System.setProperty("webdriver.chrome.driver","/Users/stask/Automation/installation/chromedriver");
			 driver = new ChromeDriver();
		}
		else if(browserName.equals ("firefox"))  {
			System.setProperty("webdriver.gecko.driver","/Users/stask/Automation/installation/geckodriver");
			 driver = new FirefoxDriver();
		}	
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	} 
}
 