package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'vinit mangal')]")
	WebElement userLabel;

	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(text(),'New Deal')]")
	WebElement newDealLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement Tasklink;
	
	@FindBy(xpath="//a[contains(text(),'New Task')]")
	WebElement newTasklink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContact;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink(){
		TestUtil.switchToFrame();
		contactslink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealslink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTaksLink(){
		TestUtil.switchToFrame();
		Tasklink.click();
		return new TasksPage();
	}
	
	
	public TasksPage clickOnNewTaksLink(){
		TestUtil.switchToFrame();
		Actions action = new Actions(driver);
		action.moveToElement(Tasklink).perform();
		newTasklink.click();
		return new TasksPage();
	}
	
	public boolean verifyCorrectUserName(){
		return userLabel.isDisplayed();
		
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactslink).perform();
		newContact.click();
	}
	
	public DealsPage clickOnNewDealsLink(){
		TestUtil.switchToFrame();
		Actions action = new Actions(driver);
		action.moveToElement(dealslink).perform();
		newDealLink.click();
		return new DealsPage();
	}
	
}
