package com.tn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	@FindBy(linkText = "My Account")
	private WebElement MyAccountLink;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(linkText = "Shopping Cart")
	private WebElement shoppingCart;
	
	@FindBy(css = "input.form-control.input-lg")
	private WebElement searchBox;
	
	@FindBy(css = "button.btn.btn-default.btn-lg")
	private WebElement searchButton;
	
	@FindBy (linkText = "Register")
	private WebElement registerLink;
	
	@FindBy (linkText = "Desktops")
	private WebElement desktopsLink;
	
	@FindBy (linkText = "Laptops & Notebooks")
	private WebElement laptopsNotebooksLink;
	
	@FindBy (linkText = "Components")
	private WebElement componentsLink;	
	
	@FindBy (linkText = "Tablets")
	private WebElement tabletsLink;	
	
	@FindBy (linkText = "Software")
	private WebElement softwareLink;
	
	@FindBy(linkText = "Phones & PDAs")
	private WebElement phonesPDALink;
	
	@FindBy(linkText = "Cameras")
	private WebElement camerasLink;

	@FindBy(linkText = "MP3 Players")
	private WebElement mp3PlayersLink;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnMyAccount() {
		MyAccountLink.click();
	}
	
	public LoginPage selectLoginOption() {
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public void enterProductDetails(String productName) {
		searchBox.sendKeys(productName);
	}
	
	public SearchPage clickOnSearchButton() {
		searchButton.click();
		return new SearchPage(driver);
	}
	
	public RegisterPage clickOnRegister() {
		registerLink.click();
		return new RegisterPage(driver);
	}
	public boolean verifyPresenceOfDesktops() {
		boolean presenceOfDesktops = desktopsLink.isDisplayed();
		return presenceOfDesktops;
	}
	public boolean verifyPresenceOfLaptops() {
		boolean presenceOfLaptops = laptopsNotebooksLink.isDisplayed();
		return presenceOfLaptops;
	}
	public boolean verifyPresenceOfComponents() {
		boolean presenceOfComponents = componentsLink.isDisplayed();
		return presenceOfComponents;
	}
	public boolean verifyPresenceOfTablets() {
		boolean presenceOfTablets = tabletsLink.isDisplayed();
		return presenceOfTablets;
	}
	public boolean verifyPresenceOfSoftware() {
		boolean presenceOfSoftware = softwareLink.isDisplayed();
		return presenceOfSoftware;
	}
	public boolean verifyPresenceOfPhonesPDA() {
		boolean presenceOfPhonesPDA = phonesPDALink.isDisplayed();
		return presenceOfPhonesPDA;
	}
	public boolean verifyPresenceOfCameras() {
		boolean presenceOfCameras = camerasLink.isDisplayed();
		return presenceOfCameras;
	}
	public boolean verifyPresenceOfMP3Players() {
		boolean presenceOfMP3Players = mp3PlayersLink.isDisplayed();
		return presenceOfMP3Players;
	}
}