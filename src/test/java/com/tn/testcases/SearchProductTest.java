package com.tn.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tn.pages.CheckoutPage;
import com.tn.pages.HomePage;
import com.tn.pages.SearchPage;
import com.tn.testBase.TestBase;

public class SearchProductTest extends TestBase{
	
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	public SearchPage searchpage;
	public CheckoutPage checkoutpage;
	
	public SearchProductTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver = openApplication(prop.getProperty("browser"));
	}
	
	@Test
	public void verifyValidProductCheckout() {
		HomePage homepage = new HomePage(driver);
		homepage.enterProductDetails(dataProp.getProperty("productName"));
		searchpage = homepage.clickOnSearchButton();
		softassert.assertTrue(searchpage.verifyValidProducts());
		searchpage.chooseHPLaptop();
		searchpage.clickAddToCart();
		searchpage.clickShoppingCart();
		CheckoutPage checkoutpage = new CheckoutPage(driver);
		softassert.assertTrue(checkoutpage.verifyProductBeforeCheckout());
		checkoutpage.clickCheckout();
		checkoutpage.clickGuestAccount();
		checkoutpage.clickContinue();
		checkoutpage.enterFirstName(dataProp.getProperty("firstNameText"));
		checkoutpage.enterLastName(dataProp.getProperty("lastNameText"));
		checkoutpage.enterEmail(dataProp.getProperty("emailText"));
		checkoutpage.enterTelephone(dataProp.getProperty("telephoneText"));
		checkoutpage.enterCompany(dataProp.getProperty("companyText"));
		checkoutpage.enterAddress1(dataProp.getProperty("address1Text"));
		checkoutpage.enterCity(dataProp.getProperty("cityText"));
		checkoutpage.enterPostcode(dataProp.getProperty("postcodeText"));
		checkoutpage.enterCountry();
		checkoutpage.enterRegion();
		checkoutpage.clickGuestContinue();
		checkoutpage.clickShippingContinue();
		checkoutpage.clickAgree();
		checkoutpage.clickPaymentContinue();
		checkoutpage.clickConfirm();
		
		String actualMessage = checkoutpage.retrieveOrderSuccessfulMessage();
		String expectedMessage = dataProp.getProperty("orderSuccessfulMessage");
		softassert.assertTrue(actualMessage.equals(expectedMessage));
		softassert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
