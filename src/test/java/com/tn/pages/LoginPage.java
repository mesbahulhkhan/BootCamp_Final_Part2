package com.tn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(css = "input.btn.btn-primary")
	private WebElement loginButton;
	
	@FindBy(css = "div.alert.alert-danger.alert-dismissible")
	private WebElement warningNoMatch;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String emailText) {
		emailField.sendKeys(emailText);
	}
	public void enterPassword (String passwordText) {
		passwordField.sendKeys(passwordText);
	}
	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}
	public String retrieveNoMatchMessage() {
		String warningMessage = warningNoMatch.getText();
		return warningMessage;
	}
}
