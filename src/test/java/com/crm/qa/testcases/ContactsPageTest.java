package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	//TestUtil testUtil;
	ContactsPage contactsPage;
	String sheet="D:/Java_training/programms_WS/FreeCRMTest1/src/main/java/com/crm/qa/testData/FreeCrmTestData.xlsx";
	public ContactsPageTest(){
		super();
	}
	
	
	
	
	@BeforeMethod
	public void setup(){
		initialization();		
		loginpage = new LoginPage();
		String un =prop.getProperty("username");
		String pwd =prop.getProperty("password");
		homepage =loginpage.login(un, pwd);		
		contactsPage =homepage.clickOnContactsLink();
	}
	
	@BeforeTest
	public void test(){
		System.out.println("This is Before Method");
	}
	
	@Test(priority=1)
	public void verifyContactsPageTest(){	
		Assert.assertTrue(contactsPage.verifyContactsPage(),"Contacts Label is missing on the page");		
	}
	
	//@Test(priority=2)
	public void selectContactTest(){
		
		contactsPage.selectContactsByName("VK Agarwal");
		contactsPage.selectContactsByName("aaa bbb");
	}
	
	//Using 2D Array
	/*@DataProvider
	public Object[][] getCRMTestData(){
		Object[][] data=TestUtil.getDataFromExcel(sheet);
		
		System.out.println("***** Data Read From Sheet Starts*****");
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data[i].length;j++){
				System.out.print(data[i][j]+" ");
			}
			System.out.println(" ");
		}*/
	
	//Using ArrayList
	@DataProvider
	public Iterator<String[]> getCRMTestData(){
		ArrayList<String[]> datalist=TestUtil.getDataFromExcel(sheet);
		
		System.out.println("***** Data Read From Sheet Starts*****");
		for (String[] rowarr : datalist) {
			System.out.println(Arrays.toString(rowarr));
		}
		
		System.out.println("***** Data Read From Sheet Ends*****");
		
		return datalist.iterator();
	}
	
	
	
	@Test(dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String fname, String lname, String company){
		homepage.clickOnNewContactLink();		
		contactsPage.createNewContact(title, fname, lname, company);
		
	}
	
	@AfterMethod
	public void tearDown(){
		System.out.println("Insode Tear Down method");
		driver.quit();
	}
}
