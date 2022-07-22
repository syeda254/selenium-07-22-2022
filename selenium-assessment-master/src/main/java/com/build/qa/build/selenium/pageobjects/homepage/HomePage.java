package com.build.qa.build.selenium.pageobjects.homepage;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class HomePage extends BasePage {
	
	
	
			By searchbar=By.xpath("//input[@class='text-input search react-search-input-normal js-reload-value']");

	
			By search = By.xpath("//div[@id='react-type-ahead-normal']//a[@class='fg-icon-search']");
			
			By ProductName=By.xpath("//h1[@class='product__name']");
			
			By ProductNameFirefox=By.xpath("//span[@itemprop='productID']");
	
	public void clickOnSearchBar()
	{
	
		driver.findElement(searchbar).click();
		driver.findElement(searchbar).sendKeys("Moen m6702bn");
		
	}
	public void searchIcon()
	{
	
		driver.findElement(search).click();
		
	}
	
	
	public void verifyBrandName() throws InterruptedException
	{
		 Thread.sleep(3000);

		 String brandname = driver.findElement(ProductName).getText();
		 Thread.sleep(3000);
		 assertEquals(brandname,"Genta™ Single Handle Centerset Bathroom Sink Faucet with Pop-Up Drain Assembly in Brushed Nickel");
		 Thread.sleep(3000);

			
		
	}
	public void verifyproductId()
	{
		
		 String productID = driver.findElement(By.xpath("//span[@itemprop='productID']")).getText();
		 assertEquals(productID, "Part #M6702BN");
	}
	

	private By homePageWrapper;
	
	public HomePage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		homePageWrapper = By.cssSelector("#wrapper.homepage");
	}
	
	public boolean onHomePage() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(homePageWrapper)) != null;
	}
}
