package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;


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
	
	
	@FindBy(css = ("[routerlink*='myorders']"))
	WebElement orderHeader;
	
	public void waitforElementToAppear(By findBy)
	{
		
	WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	
	}
	
	public void waitforWebElementToAppear(WebElement findBy)
	{
		
	WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findBy));
	
	}
	
	public void waitForElementToDisapper(WebElement ele) throws InterruptedException
	{
		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver ,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));

	}
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cartPage= new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrdersPage()
	{
		orderHeader.click();
		OrderPage orderPage= new OrderPage(driver);
		return orderPage;
	}
	
}
