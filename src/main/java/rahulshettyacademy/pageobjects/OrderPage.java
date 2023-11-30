package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{

	
	WebDriver driver;
	
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productNames;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	
	
	public OrderPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
					
	}
	public Boolean verifyOrderDisplay(String productName)
	{
		Boolean match = productNames.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	
	
	

}
