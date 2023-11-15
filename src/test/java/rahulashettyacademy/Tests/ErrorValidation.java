package rahulashettyacademy.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;


@Test
public class ErrorValidation extends BaseTest {

	public void errorValidation()
	{
		landingPage.loginApplication("tanzila@gmail.com", "Golu62*");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}
	
	
	
	
}
