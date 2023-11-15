package rahulashettyacademy.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		String productName="ZARA COAT 3";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		System.out.println("starting script :");
		driver.manage().window().maximize();
		
		
		
		LandingPage landingPage=new LandingPage(driver);
		landingPage.goTo();
		ProductCatalogue productCatalogue=landingPage.loginApplication("tanzila@gmail.com", "Golu62**");
		
		
		//ProductCatalogue productCatalogue= new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		
		
		
		System.out.println(products);
		
		productCatalogue.addProductToCart(productName);
		
		

		
		//check product in cart 
		CartPage cartPage=productCatalogue.goToCartPage();
		Boolean match=cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		
		System.out.println("product matched ---------");
		
		//click checkout 
		CheckoutPage checkoutPage=cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		
		System.out.println("india selected : ");
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();
		
		
		
		
		
		
		String confirmMessage=confirmationPage.getConfirmationMessage();
			
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(confirmMessage));
	}

}
