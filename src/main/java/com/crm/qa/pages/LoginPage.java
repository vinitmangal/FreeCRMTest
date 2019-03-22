package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage  extends TestBase{

	//Page Factory - Object Repository:
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	@FindBy(xpath="//img[@class='img-responsive' and @alt='free crm logo']")
	WebElement crmLogo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	 
	public HomePage login(String un,String pwd){
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOf(username));
		wait.until(ExpectedConditions.visibilityOf(password));	
		
		try{
			Thread.sleep(5000);
		driver.switchTo().frame("intercom-borderless-frame");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'CRMPRO')]"))).build().perform();
		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]/span")).click();
		}
		catch (Exception e) {
			System.out.println("Exception occurred while closing chat box");
			e.printStackTrace();
			
		}
			
		
		username.clear();
		password.clear();
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		
		wait.until(ExpectedConditions.elementToBeClickable(login));
		login.click();
		
		System.out.println("Login Successful");
		
		return new HomePage();
	}
}
