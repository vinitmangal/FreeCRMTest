package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest(){
		super();		
	}

	@BeforeMethod
	public void setup(){
		initialization();		
		loginpage = new LoginPage();
		String un =prop.getProperty("username");
		String pwd =prop.getProperty("password");
		homepage =loginpage.login(un, pwd);
		testUtil = new TestUtil();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle =homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home Page Title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		TestUtil.switchToFrame();
		Boolean flag =homepage.verifyCorrectUserName();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		
		contactsPage = homepage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
