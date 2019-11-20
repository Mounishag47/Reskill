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

public class RetailHomePOM {
	
private WebDriver driver; 
	
	public RetailHomePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}

	@FindBy(id="search_button")
	private WebElement search;
	
	@FindBy(id="filter_keyword")
	private WebElement searchField;
		
	public void mouseHoverSearch() {
		Actions ac= new Actions(driver);
		ac.moveToElement(this.search).click().perform();
	}
	
	public void clickSearchField() {
		Actions ac= new Actions(driver);
		ac.moveToElement(this.searchField).click().perform();
		//this.searchField.click();
	}
	
	public void enterSearchField(String keyword) {
		this.searchField.sendKeys(keyword);
	}
	
	public void clickSearch() {
	this.search.click();
	}
	
		
	}
