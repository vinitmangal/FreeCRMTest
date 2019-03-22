package com.crm.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.testcases.DealsPageTest;

public class DealsPage  extends TestBase{
	
	@FindBy(id="title")
	WebElement title;
	
	@FindBy(xpath="//input[@name='client_lookup']//following-sibling::input[@type='button']")
	WebElement company_lookup;
	Logger log;
	
	@FindBy(css="select[name='type'][size='1']")
	WebElement typeDropDown;

	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(name="source")
	WebElement source;
	
	@FindBy(xpath="//input[@value='Save and Create Another']//preceding-sibling::input")
	WebElement saveBtn;
	
	public DealsPage(){
		PageFactory.initElements(driver, this);
		log = Logger.getLogger(DealsPageTest.class);
	}
	public void createNewDeal(String titlevalue, String typeValue, String sourceValue, String statusValue){
		title.sendKeys(titlevalue);
		
		//this code is to select company using Lookup window
		/*
		String mainWindow = driver.getWindowHandle();
		company_lookup.click();		
		Set<String> windowsSet = driver.getWindowHandles();		
		for (String win : windowsSet) {
			if(!win.equals(mainWindow)){
				driver.switchTo().window(win);				
				log.info("Title of child"+driver.getTitle());
				driver.findElement(By.id("search")).sendKeys("ab");
				driver.findElement(By.cssSelector("input[type='submit']")).click();
				driver.close();
				//driver.findElement(By.xpath("//a[text()='abcd']")).click();
								
			}
		}
			driver.switchTo().window(mainWindow);
		Set<String> windowsSet2 = driver.getWindowHandles();
		System.out.println(windowsSet2);*/

			Select type = new Select(typeDropDown);
			type.selectByVisibleText(typeValue);
			
			Select sourceEle = new Select(source);
			sourceEle.selectByVisibleText(sourceValue);
		
			String statusXPath = "//input[@type='radio' and @value='"+statusValue+"']";
			WebElement status = driver.findElement(By.xpath(statusXPath));
			status.click();
			
			saveBtn.click();
	}

}
