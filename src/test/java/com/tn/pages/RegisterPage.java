package com.tn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	public WebDriver driver;
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicyCheckbox;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement continueButton;
	
	@FindBy(css = "div.alert.alert-danger.alert-dismissible")
	private WebElement emailAlreadyRegistered;
	
	@FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement noFirstNameMessage;
	
	@FindBy(xpath = "//div[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement noLastNameMessage;
	
	@FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement noEmailMessage;
	
	@FindBy(xpath = "//div[text()='Telephone must be between 3 and 32 characters!']")
	private WebElement noMobileNumberMessage;
	
	@FindBy(xpath = "//div[text()='Password must be between 4 and 20 characters!']")
	private WebElement noPasswordMessage;
	
	@FindBy(xpath = "//div[text()='Warning: You must agree to the Privacy Policy!']")
	private WebElement noPrivacyAgreeMessage;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterFirstNameField(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastNameField(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmailField(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	public void enterTelephoneField(String telephoneText) {
		telephoneField.sendKeys(telephoneText);
	}
	
	public void enterPasswordField(String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPasswordField(String confirmPasswordText) {
		confirmPasswordField.sendKeys(confirmPasswordText);
	}
	
	public void checkPrivacyPolicy() {
		privacyPolicyCheckbox.click();
	}
	
	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
}
	public String retrieveEmailAlreadyRegisteredMessage() {
		String alreadyRegisteredMessage = emailAlreadyRegistered.getText();
		return alreadyRegisteredMessage;
	}
	
	public String retrieveNoFirstNameProvidedMessage() {
		String noFirstName = noFirstNameMessage.getText();
		return noFirstName;
	}
	public String retrieveNoLastNameProvidedMessage() {
		String noLastName = noLastNameMessage.getText();
		return noLastName;
	}
	public String retrieveNoEmailProvidedMessage() {
		String noEmail = noEmailMessage.getText();
		return noEmail;
	}
	public String retrieveNoMobileNumberProvidedMessage() {
		String noMobileNumber = noMobileNumberMessage.getText();
		return noMobileNumber;
	}
	public String retrieveNoPasswordProvidedMessage() {
		String noPassword = noPasswordMessage.getText();
		return noPassword;
	}
	public String retrieveNoPrivaceAgreeMessage() {
		String noPrivacy = noPrivacyAgreeMessage.getText();
		return noPrivacy;
	}
}
