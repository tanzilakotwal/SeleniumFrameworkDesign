package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements( driver,this );
	}
	
	//WebElement userEmail=driver.findElement(By.id("userEmail"));
	//PageFactory
	
	//userEmail
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	//password
	@FindBy(id="userPassword")
	WebElement passwords;
	
	//Submit button
	@FindBy(id="login")
	WebElement submit;
	
	public void loginApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		passwords.sendKeys(password);
		submit.click();
		
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");

	}
	
	
	


}
