package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailSearchResultsPOM {

private WebDriver driver; 
	
	public RetailSearchResultsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}

	@FindBy(xpath="//img[@alt='Earrings']")
	private WebElement earRingProd;
	
	public void selectearRingProd() {
		this.earRingProd.click();
		}
	
}
