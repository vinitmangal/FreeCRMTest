package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class TasksPage extends TestBase{

	@FindBy(xpath="//em[contains(text(),'Showing all tasks')]")
	WebElement taskLabel;
	
	@FindBy(id="title")
	WebElement title;
	
	@FindBy(id="completion")
	WebElement completion;
	
	
	@FindBy(name="task_type")
	WebElement task_type;
	
	@FindBy(xpath="//input[@name='contact_lookup']")
	WebElement key_contact;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement key_company;
	
	@FindBy(id="description")
	WebElement description;
	
	@FindBy(xpath="(//legend[contains(text(),'Task Information')]/following-sibling::form//table//input[@type='submit' and @value='Save'])[1]")
	WebElement saveBtn;
	
	public TasksPage(){
		System.out.println("Inside TasksPage Constructor");
		PageFactory.initElements(driver, this);
	}
	
	public void createNewTask(String title,String comptetion,String taskType,
							  String keyContact, String keyCompany,String desc){
		this.title.sendKeys(title);
		
		this.completion.sendKeys(comptetion);
		
		Select selectObj = new Select(task_type);
		selectObj.selectByVisibleText(taskType);
		
		key_contact.sendKeys(keyContact);
		key_company.sendKeys(keyCompany);
		description.sendKeys(desc);
		saveBtn.click();
	}
	
	public boolean verifyTasksLabel(){
		return taskLabel.isDisplayed();
	}
	
	
}
