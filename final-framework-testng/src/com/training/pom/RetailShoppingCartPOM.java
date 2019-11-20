package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailShoppingCartPOM {
	
private WebDriver driver; 
	
	public RetailShoppingCartPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(css="i.fa.fa-times-circle")
	private WebElement removeProduct;
	
	@FindBy(css="i.fa.fa-refresh")
	private WebElement RefreshProduct;
	
	@FindBy(xpath="//div[@class='tb_text_wrap tb_sep']/p")
	private WebElement cartEmptyText;
	
	public void removeProduct() {
	this.removeProduct.click();
    }
	
	public void RefreshProduct() {
	this.RefreshProduct.click();
	}
	
	public String cartEmptyText() {
	String tex=this.cartEmptyText.getText();
    return tex;
	}
		
		
		
		

}
