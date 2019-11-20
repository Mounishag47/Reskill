package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPOM {
private WebDriver driver; 
	
	public DashboardPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="button-menu")
	private WebElement navigationBar;
	
	@FindBy(css="i.fa.fa-tags.fw")
	private WebElement catalog;
	
    @FindBy(xpath="//li[@id=\"menu-catalog\"]/ul/li[1]/a")
    private WebElement categories;
    
    @FindBy(xpath= "//tbody/tr[1]/td[1]")
    private WebElement australiaCheckbox;
    
    @FindBy(xpath= "//tbody/tr[2]/td[1]")
    private WebElement categoryNameCheckbox;
    
	@FindBy(css="i.fa.fa-trash-o")
	private WebElement delete;
	
	@FindBy(css="div.alert.alert-success")
	private WebElement successMessage;
	
	@FindBy(id="input-price")
	private WebElement price;
	
	@FindBy(id="input-status")
	private WebElement status;
	
	@FindBy(id="input-name")
	private WebElement productName;
	
	@FindBy(id="input-model")
	private WebElement model;
	
	@FindBy(id="input-quantity")
	private WebElement quantity;
	
	@FindBy(id="input-image")
	private WebElement image;
	
	@FindBy(id="button-filter")
	private WebElement filter;
	
	@FindBy(css=".collapse.in>li:nth-child(2)")
    private WebElement products;
	
	@FindBy(css="i.fa.fa-plus")
    private WebElement addNewIcon;
	
	
	public void clickNavigationBar() {
		this.navigationBar.click();
	}
	
	public void clickCatalog() {
		this.catalog.click();
	}
	
	public void clickCategories() {
		this.categories.click();
	}

	public String pageTitle() {
		String title=driver.getTitle();
		return title;
	}
	
	public void clickAustraliaCheckbox() {
		this.australiaCheckbox.click();
	}

	public void clickCategoryNameCheckbox() {
		this.categoryNameCheckbox.click();
	}
	
	public void delete() {
		this.delete.click();
	}
	
	public void alert() {
		driver.switchTo().alert().accept();
	}
	public String getTextSuccessMessage() {
		String st=this.successMessage.getText();
		return st;
	}

	public void clickOnPrice(String price) {
		this.price.sendKeys(price);
	}

	public void clickOnStatus(String status) {
		this.status.sendKeys(status);
	}

	public void clickOnProductName(String productName) {
		this.productName.sendKeys(productName);
	}

	public void clickOnModel(String model) {
		this.model.sendKeys(model);
	}
	
	public void clickOnQuantity(String quantity) {
		this.quantity.sendKeys(quantity);
	}
	
	public void clickOnImage(String image) {
		this.image.sendKeys(image);
	}
	public void clickFilter() {
		this.filter.click();
	}
	public void clickProducts() {
		this.products.click();
	}
	public void clickAddNewIcon() {
		this.addNewIcon.click();
	}
}
