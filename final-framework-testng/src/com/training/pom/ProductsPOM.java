package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPOM {
private WebDriver driver; 
	
	public ProductsPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}

	
	@FindBy(id="input-name1")
	private WebElement productName;
	
	@FindBy(id="input-meta-title1")
	private WebElement metaTagTitle;

	@FindBy(linkText="Data")
	private WebElement datalink;
	
	@FindBy(id="input-price")
	private WebElement price;
	
	@FindBy(id="input-model")
	private WebElement model;
	
	@FindBy(id="input-quantity")
	private WebElement quantity;
	
	@FindBy(linkText="Links")
	private WebElement linkslink;
	
	@FindBy(id="input-category")
	private WebElement category;
	
	@FindBy(xpath="//div/ul[@class='dropdown-menu']/li[1]")
	private WebElement categoryDropdownElement;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveButton;

	
	@FindBy(css="div.alert.alert-success")
	private WebElement modifiedSuccessmsg;
	
	public void EnterproductName(String product) {
		this.productName.sendKeys(product);
	}
	
	public void EnterMetaTagTitle(String metatitle) {
		this.metaTagTitle.sendKeys(metatitle);
	}
	public void clickDatalink() {
		this.datalink.click();
	}
	
	public void EnterModel(String modelno) {
		this.model.sendKeys(modelno);
	}
	public void EnterPrice(String price) {
		this.price.sendKeys(price);
	}
	public void EnterQuantity(String quantity) {
		this.quantity.clear();
		this.quantity.sendKeys(quantity);
	}
	public void clickLinkslink() {
		this.linkslink.click();
	}
	public void clickCategory() {
		Actions act=new Actions(driver);
		act.click(category).moveToElement(categoryDropdownElement).click().build().perform();
	}
	public void clickSaveButton() {
		this.saveButton.click();
	}
	
	public String validateModifiedSuccessmsg()
	{
		String sm=this.modifiedSuccessmsg.getText();
		return sm;
	}
}
