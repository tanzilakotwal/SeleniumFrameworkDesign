package rahulshettyacademy.TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	
	public void initializeDriver() throws IOException
	{
		
		Properties prop =new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Tanzila Kotwal\\eclipse-workspace\\SeleniumFrameworkDesign_practiseECommerce\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			
		}
		else if(browserName.equalsIgnoreCase("EDGE"))
		{
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
	}
	
	
}
