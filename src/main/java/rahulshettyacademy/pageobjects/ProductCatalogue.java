package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements( driver,this );
	}
	
	//PageFactory

		
	//Products list 
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage=By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		//waitforElementToAppear(productsBy);// working with rahul shetty code 
		return products;
		
	}
	
	//get product by name
	public WebElement getProductByName(String productName)
	{
		WebElement prod=getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
		
	}
	
	//add to cart 
	public void addProductToCart(String productName)
	{
		System.out.println("product name is --> " + productName);
		
		WebElement prod=getProductByName(productName);
		prod.findElement(addToCart).click();		
		
		

		waitforElementToAppear(toastMessage);
		waitForElementToDisapper(spinner);
		
		

		
		
	}
	
	
	
	
	
	


}
