package rahulshettyacademy.Tests;

import java.io.IOException;
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
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {

	String productName="ZARA COAT 3";
	
	@Test
	public  void submitOrder() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		System.out.println("SubmitOrder test started ----------");
		
		
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
		
		System.out.println("SubMitorder  test Completed ----------");
	}

	
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void orderHistoryTest()
	{
		
		ProductCatalogue productCatalogue=landingPage.loginApplication("tanzila@gmail.com", "Golu62**");
		OrderPage ordersPage=productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));
	}
}
