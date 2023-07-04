package com.tn.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	public WebDriver driver;

	@FindBy(linkText = "HP LP3065")
	private WebElement validProducts;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement clickOnHPLaptop;
	
	@FindBy(css = "button.btn.btn-primary.btn-lg.btn-block")
	private WebElement clickOnAddToCart;
	
	@FindBy(linkText = "Shopping Cart")
	private WebElement clickOnShoppingCart;
		
	public SearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyValidProducts() {
		boolean presenceValidProducts = validProducts.isDisplayed();
		return presenceValidProducts;
	}
	public void chooseHPLaptop() {
		clickOnHPLaptop.click();
	}
	public void clickAddToCart() {
		clickOnAddToCart.click();
	}
	public void clickShoppingCart() {
		clickOnShoppingCart.click();
	}
}
