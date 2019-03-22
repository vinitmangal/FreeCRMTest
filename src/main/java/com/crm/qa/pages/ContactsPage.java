package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	@CacheLookup
	WebElement contactsLabel;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement surName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement savebtn;
	
	public ContactsPage(){
		System.out.println("inside Contactsage constructor");
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsPage(){
		System.out.println("inside verifyContactsPage()");
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(contactsLabel));
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"') and @context='contact' ]/parent::td[@class='datalistrow']/preceding-sibling::td/input[@name='contact_id']")).click();
		
	}
	
	public void createNewContact(String title,String fname,String lname,String company){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);		
		firstName.sendKeys(fname);
		surName.sendKeys(lname);
		this.company.sendKeys(company);
		savebtn.click();
	}
	
}
