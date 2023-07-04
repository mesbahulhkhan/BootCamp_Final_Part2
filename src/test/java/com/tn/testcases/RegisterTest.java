package com.tn.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tn.pages.AccountPage;
import com.tn.pages.AccountSuccessPage;
import com.tn.pages.HomePage;
import com.tn.pages.RegisterPage;
import com.tn.testBase.TestBase;
import com.tn.utils.Utilities;

public class RegisterTest extends TestBase{
	
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	public RegisterPage registerpage;
	public AccountSuccessPage accountsuccesspage;
	public AccountPage accountpage;
	
	public RegisterTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		driver = openApplication(prop.getProperty("browser"));
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		registerpage = homepage.clickOnRegister();
	}
	
	@Test(priority = 1)
	public void verifyRegistrationWithOnlyMandatoryFields() {
		registerpage.enterFirstNameField(dataProp.getProperty("firstName"));
		registerpage.enterLastNameField(dataProp.getProperty("lastName"));
		registerpage.enterEmailField(Utilities.emailDateTimeStamp());
		registerpage.enterTelephoneField(dataProp.getProperty("mobileNumber"));
		registerpage.enterPasswordField(prop.getProperty("validPassword"));
		registerpage.enterConfirmPasswordField(prop.getProperty("validPassword"));
		registerpage.checkPrivacyPolicy();
		accountsuccesspage = registerpage.clickOnContinueButton();
		
		String actualMessage = accountsuccesspage.retrieveAccountCreatedMessage();
		String expectedMessage = dataProp.getProperty("accountSuccessMessage");
		softassert.assertTrue(actualMessage.equals(expectedMessage));
		softassert.assertAll();
	}
	
	@Test(priority = 2)
	public void verifyRegistrationWithExistingEmail() {
		registerpage.enterFirstNameField(dataProp.getProperty("firstName"));
		registerpage.enterLastNameField(dataProp.getProperty("lastName"));
		registerpage.enterEmailField(dataProp.getProperty("existingEmail"));
		registerpage.enterTelephoneField(dataProp.getProperty("mobileNumber"));
		registerpage.enterPasswordField(prop.getProperty("validPassword"));
		registerpage.enterConfirmPasswordField(prop.getProperty("validPassword"));
		registerpage.checkPrivacyPolicy();
		registerpage.clickOnContinueButton();
		
		String actualExistingEmailMessage = registerpage.retrieveEmailAlreadyRegisteredMessage();
		String expectedExistingEmailMessage = dataProp.getProperty("emailAlreadyRegisteredMessage");
		softassert.assertTrue(actualExistingEmailMessage.equals(expectedExistingEmailMessage));
		softassert.assertAll();
	}
	
	@Test(priority = 3)
	public void verifyRegistrationWithAllFieldsExceptFirstName() {
		registerpage.enterLastNameField(dataProp.getProperty("lastName"));
		registerpage.enterEmailField(Utilities.emailDateTimeStamp());
		registerpage.enterTelephoneField(dataProp.getProperty("mobileNumber"));
		registerpage.enterPasswordField(prop.getProperty("validPassword"));
		registerpage.enterConfirmPasswordField(prop.getProperty("validPassword"));
		registerpage.checkPrivacyPolicy();
		registerpage.clickOnContinueButton();

		String actualNoFirstNameMessage = registerpage.retrieveNoFirstNameProvidedMessage();
		String expectedNoFirstNameMessage = dataProp.getProperty("noFirstNameMessage");
		softassert.assertTrue(actualNoFirstNameMessage.equals(expectedNoFirstNameMessage));
		softassert.assertAll();
	}
	
	@Test(priority = 4)
	public void verifyRegistrationWithAllFieldsExceptLastName() {
		registerpage.enterFirstNameField(dataProp.getProperty("firstName"));
		registerpage.enterEmailField(Utilities.emailDateTimeStamp());
		registerpage.enterTelephoneField(dataProp.getProperty("mobileNumber"));
		registerpage.enterPasswordField(prop.getProperty("validPassword"));
		registerpage.enterConfirmPasswordField(prop.getProperty("validPassword"));
		registerpage.checkPrivacyPolicy();
		registerpage.clickOnContinueButton();

		String actualNoLastNameMessage = registerpage.retrieveNoLastNameProvidedMessage();
		String expectedNoLastNameMessage = dataProp.getProperty("noLastNameMessage");
		softassert.assertTrue(actualNoLastNameMessage.equals(expectedNoLastNameMessage));
		softassert.assertAll();
	}
	
	@Test(priority = 5)
	public void verifyRegistrationWithAllFieldsExceptEmail() {
		registerpage.enterFirstNameField(dataProp.getProperty("firstName"));
		registerpage.enterLastNameField(dataProp.getProperty("lastName"));
		registerpage.enterTelephoneField(dataProp.getProperty("mobileNumber"));
		registerpage.enterPasswordField(prop.getProperty("validPassword"));
		registerpage.enterConfirmPasswordField(prop.getProperty("validPassword"));
		registerpage.checkPrivacyPolicy();
		registerpage.clickOnContinueButton();

		String actualNoEmailMessage = registerpage.retrieveNoEmailProvidedMessage();
		String expectedNoEmailMessage = dataProp.getProperty("noEmailMessage");
		softassert.assertTrue(actualNoEmailMessage.equals(expectedNoEmailMessage));
		softassert.assertAll();
	}
	
	@Test(priority = 6)
	public void verifyRegistrationWithAllFieldsExceptMobileNumber() {
		registerpage.enterFirstNameField(dataProp.getProperty("firstName"));
		registerpage.enterLastNameField(dataProp.getProperty("lastName"));
		registerpage.enterEmailField(Utilities.emailDateTimeStamp());
		registerpage.enterPasswordField(prop.getProperty("validPassword"));
		registerpage.enterConfirmPasswordField(prop.getProperty("validPassword"));
		registerpage.checkPrivacyPolicy();
		registerpage.clickOnContinueButton();

		String actualNoMobileNumberMessage = registerpage.retrieveNoMobileNumberProvidedMessage();
		String expectedNoMobileNumberMessage = dataProp.getProperty("noMobileNumberMessage");
		softassert.assertTrue(actualNoMobileNumberMessage.equals(expectedNoMobileNumberMessage));
		softassert.assertAll();
	}
	
	@Test(priority = 7)
	public void verifyRegistrationWithAllFieldsExceptPassword() {
		registerpage.enterFirstNameField(dataProp.getProperty("firstName"));
		registerpage.enterLastNameField(dataProp.getProperty("lastName"));
		registerpage.enterEmailField(Utilities.emailDateTimeStamp());
		registerpage.enterTelephoneField(dataProp.getProperty("mobileNumber"));
		registerpage.checkPrivacyPolicy();
		registerpage.clickOnContinueButton();

		String actualNoPasswordMessage = registerpage.retrieveNoPasswordProvidedMessage();
		String expectedNoPasswordMessage = dataProp.getProperty("noPasswordMessage");
		softassert.assertTrue(actualNoPasswordMessage.equals(expectedNoPasswordMessage));
		softassert.assertAll();
	}
	
	@Test(priority = 8)
	public void verifyRegistrationWithAllFieldsExceptPrivacy() {
		registerpage.enterFirstNameField(dataProp.getProperty("firstName"));
		registerpage.enterLastNameField(dataProp.getProperty("lastName"));
		registerpage.enterEmailField(Utilities.emailDateTimeStamp());
		registerpage.enterTelephoneField(dataProp.getProperty("mobileNumber"));
		registerpage.enterPasswordField(prop.getProperty("validPassword"));
		registerpage.enterConfirmPasswordField(prop.getProperty("validPassword"));
		registerpage.clickOnContinueButton();

		String actualNoPrivacyAgreeMessage = registerpage.retrieveNoPrivaceAgreeMessage();
		String expectedNoPrivacyAgreeMessage = dataProp.getProperty("noPrivacyAgreeMessage");
		softassert.assertTrue(actualNoPrivacyAgreeMessage.equals(expectedNoPrivacyAgreeMessage));
		softassert.assertAll();
	}
	
	@Test(priority = 9)
	public void verifyRegistrationWithAllFieldsBlank() {
		registerpage.clickOnContinueButton();
		
		String actualNoFirstNameMessage = registerpage.retrieveNoFirstNameProvidedMessage();
		String expectedNoFirstNameMessage = dataProp.getProperty("noFirstNameMessage");
		softassert.assertTrue(actualNoFirstNameMessage.equals(expectedNoFirstNameMessage));
		
		String actualNoLastNameMessage = registerpage.retrieveNoLastNameProvidedMessage();
		String expectedNoLastNameMessage = dataProp.getProperty("noLastNameMessage");
		softassert.assertTrue(actualNoLastNameMessage.equals(expectedNoLastNameMessage));
		
		String actualNoEmailMessage = registerpage.retrieveNoEmailProvidedMessage();
		String expectedNoEmailMessage = dataProp.getProperty("noEmailMessage");
		softassert.assertTrue(actualNoEmailMessage.equals(expectedNoEmailMessage));
		
		String actualNoMobileNumberMessage = registerpage.retrieveNoMobileNumberProvidedMessage();
		String expectedNoMobileNumberMessage = dataProp.getProperty("noMobileNumberMessage");
		softassert.assertTrue(actualNoMobileNumberMessage.equals(expectedNoMobileNumberMessage));
		
		String actualNoPasswordMessage = registerpage.retrieveNoPasswordProvidedMessage();
		String expectedNoPasswordMessage = dataProp.getProperty("noPasswordMessage");
		softassert.assertTrue(actualNoPasswordMessage.equals(expectedNoPasswordMessage));
		
		String actualNoPrivacyAgreeMessage = registerpage.retrieveNoPrivaceAgreeMessage();
		String expectedNoPrivacyAgreeMessage = dataProp.getProperty("noPrivacyAgreeMessage");
		softassert.assertTrue(actualNoPrivacyAgreeMessage.equals(expectedNoPrivacyAgreeMessage));
		softassert.assertAll();
		
	}	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
