package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//this is abstract component class . 
public class AbstractComponent {
	
	WebDriver driver ;
	
	public AbstractComponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(css = ("[routerlink*='cart']"))
	WebElement cartHeader;
	
	
	public void waitforElementToAppear(By findBy)
	{
		
	WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	public void waitForElementToDisapper(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	
	public void goToCartPage()
	{
		cartHeader.click();
	}
	
}
