package rahulshettyacademy.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;


@Test
public class ErrorValidation extends BaseTest {

	public void LoginErrorValidation()
	{
		landingPage.loginApplication("tanzila@gmail.com", "Golu62*");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
	
	
	
	
	@Test
	public  void ProductErrorValidation() throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		
		String productName="ZARA COAT 3";
		
		ProductCatalogue productCatalogue=landingPage.loginApplication("tanzila@gmail.com", "Golu62**");
		
		
		//ProductCatalogue productCatalogue= new ProductCatalogue(driver);
		List<WebElement> products = productCatalogue.getProductList();
		
		
		
		System.out.println(products);
		
		productCatalogue.addProductToCart(productName);
		
		

		
		//check product in cart 
		CartPage cartPage=productCatalogue.goToCartPage();
		Boolean match=cartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertTrue(match);
		
		System.out.println("product matched ---------");
		
		
	}

	
	
	
}
