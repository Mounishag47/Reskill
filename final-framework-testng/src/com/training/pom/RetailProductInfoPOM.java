package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RetailProductInfoPOM {
private WebDriver driver; 
	
	public RetailProductInfoPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}

	
	@FindBy(id="button-cart")
	private WebElement addToCart;

	@FindBy(css=".noty_text>h3")
	private WebElement cartPopupText;
	
	@FindBy(css=".noty_close>svg")
	private WebElement cartPopupClose;
	
	@FindBy(css=".tb_icon.ico-linea-ecommerce-bag")
	private WebElement shoppingCart;
	
	@FindBy(xpath="//a[text()='View Cart']")
	private WebElement viewCart;

		
		public void addToCart() {
		this.addToCart.click();
		}
		
		public String cartPopupText() {
		String text=this.cartPopupText.getText();
		return text;
		}
		
		public void cartPopupClose() {
		this.cartPopupClose.click();
		}
		
		public void mouseHovershoppingCart() {
		Actions ac= new Actions(driver);
		ac.moveToElement(this.shoppingCart).click().perform();
		}

		public void viewCart() {
		this.viewCart.click();
	    }


}
