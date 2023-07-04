package com.tn.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tn.pages.AccountPage;
import com.tn.pages.HomePage;
import com.tn.pages.LoginPage;
import com.tn.testBase.TestBase;

public class LoginTest extends TestBase{
	
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	public LoginPage loginpage;
	public AccountPage accountpage;
	
	public LoginTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver = openApplication(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		loginpage = homepage.selectLoginOption();
	}
	
	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() {
		loginpage.enterEmail(prop.getProperty("validEmail"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		accountpage = loginpage.clickOnLoginButton();
		
		softassert.assertTrue(accountpage.verifyLogin());
		softassert.assertAll();
	}
	
	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		loginpage.enterEmail(dataProp.getProperty("invalidEmail"));
		loginpage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
		
		String actualWarningMessage = loginpage.retrieveNoMatchMessage();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		softassert.assertAll();
	}
	
	@Test(priority = 3)
	public void verifyLoginWithValidEmailInvalidPassword() {
		loginpage.enterEmail(prop.getProperty("validEmail"));
		loginpage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginpage.clickOnLoginButton();
		
		String actualWarningMessage = loginpage.retrieveNoMatchMessage();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		softassert.assertAll();
	}
	
	@Test(priority = 4)
	public void verifyLoginWithInvalidEmailValidPassword() {
		loginpage.enterEmail(dataProp.getProperty("invalidEmail"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		loginpage.clickOnLoginButton();
		
		String actualWarningMessage = loginpage.retrieveNoMatchMessage();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		softassert.assertAll();
	}
	
	@Test(priority = 5)
	public void verifyLoginWithNoCredentials() {
		loginpage.clickOnLoginButton();
		
		SoftAssert softassert = new SoftAssert();
		String actualWarningMessage = loginpage.retrieveNoMatchMessage();
		String expectedWarningMessage = dataProp.getProperty("emailPasswordNoMatchMessage");
		softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		softassert.assertAll();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
