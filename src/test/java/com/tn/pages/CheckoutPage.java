package com.tn.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	public WebDriver driver;

	@FindBy(xpath = "(//a[contains(text(),'HP LP3065')])[2]")
	private WebElement verifyValidProductCheckout;
	
	@FindBy(linkText = "Checkout")
	private WebElement clickOnCheckout;
	
	@FindBy(xpath = "//label[normalize-space()='Guest Checkout']")
	private WebElement clickOnGuestCheckout;
	
	@FindBy(xpath = "//input[@id='button-account']")
	private WebElement clickOnContinue;
	
	@FindBy(id = "input-payment-firstname")
	private WebElement enterFirstNameField;
	
	@FindBy(id = "input-payment-lastname")
	private WebElement enterLastNameField;
	
	@FindBy(id = "input-payment-email")
	private WebElement enterEmailField;
	
	@FindBy(id = "input-payment-telephone")
	private WebElement enterTelephoneField;
	
	@FindBy(id = "input-payment-company")
	private WebElement enterCompanyField;
	
	@FindBy(id = "input-payment-address-1")
	private WebElement enterAddress1Field;
	
	@FindBy(id = "input-payment-city")
	private WebElement enterCityField;
	
	@FindBy(id = "input-payment-postcode")
	private WebElement enterPostcodeField;

	@FindBy(id = "input-payment-country")
	private WebElement enterCountryField;
	
	@FindBy(id = "input-payment-zone")
	private WebElement enterRegionField;
	
	@FindBy(xpath = "(//input[@id='button-guest'])[1]")
	private WebElement clickOnGuestContinue;
	
	@FindBy(id = "button-shipping-method")
	private WebElement clickOnShippingContinue;
	
	@FindBy(name = "agree")
	private WebElement clickOnAgree;
	
	@FindBy(id = "button-payment-method")
	private WebElement clickOnPaymentContinue;
	
	@FindBy(id = "button-confirm")
	private WebElement clickOnConfirm;
	
	@FindBy(xpath = "//p[text()='Your order has been successfully processed!']")
	private WebElement orderPlaced;
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCheckout() {
		clickOnCheckout.click();
	}
	public boolean verifyProductBeforeCheckout() {
		boolean presenceDuringCheckout = verifyValidProductCheckout.isDisplayed();
		return presenceDuringCheckout;
	}
	public void clickGuestAccount() {
		clickOnGuestCheckout.click();
	}
	public void clickContinue() {
		clickOnContinue.click();
	}
	public void enterFirstName(String firstNameText) {
		enterFirstNameField.sendKeys(firstNameText);
	}
	public void enterLastName(String lastNameText) {
		enterLastNameField.sendKeys(lastNameText);
	}
	public void enterEmail(String emailText) {
		enterEmailField.sendKeys(emailText);
	}
	public void enterTelephone(String telephoneText) {
		enterTelephoneField.sendKeys(telephoneText);
	}
	public void enterCompany(String companyText) {
		enterCompanyField.sendKeys(companyText);
	}
	public void enterAddress1(String address1Text) {
		enterAddress1Field.sendKeys(address1Text);
	}
	public void enterCity(String cityText) {
		enterCityField.sendKeys(cityText);
	}
	public void enterPostcode(String postcodeText) {
		enterPostcodeField.sendKeys(postcodeText);
	}
	public void enterCountry() {
		enterCountryField.click();
		int i=0;
		while(i<1) {
			enterCountryField.sendKeys(Keys.DOWN);
			i++;
		}
		enterCountryField.sendKeys(Keys.ENTER);
	}
	public void enterRegion() {
		enterRegionField.click();
		int i=0;
		while(i<12) {
			enterRegionField.sendKeys(Keys.DOWN);
			i++;
		}
		enterRegionField.sendKeys(Keys.ENTER);
	}
	public void clickGuestContinue() {
		clickOnGuestContinue.click();
	}
	public void clickShippingContinue() {
		clickOnShippingContinue.click();
	}
	public void clickAgree() {
		clickOnAgree.click();
	}
	public void clickPaymentContinue() {
		clickOnPaymentContinue.click();
	}
	public void clickConfirm() {
		clickOnConfirm.click();
	}
	public String retrieveOrderSuccessfulMessage() {
		String presenceOrderSuccessful = orderPlaced.getText();
		return presenceOrderSuccessful;
	}
}
