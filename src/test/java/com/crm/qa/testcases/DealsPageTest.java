package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class DealsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;
	Logger log = Logger.getLogger(DealsPageTest.class);
	String sheet ="D:/Java_training/programms_WS/FreeCRMTest1/src/main/java/com/crm/qa/testData/FreeCrmTestData.xlsx";
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		
		String un = prop.getProperty("username");
		String pwd = prop.getProperty("password");	
		
		homePage = loginPage.login(un, pwd);
	}
	
	@DataProvider
	public Iterator<String[]> getDataforDealCreate(){
		ArrayList<String[]> al=TestUtil.getDealsDataFromExcel(sheet);
		log.info("Printing Excel Data"+al.size());
		
		for (String[] row : al) {
			log.info(Arrays.toString(row));
		}
		return al.iterator();
	}
	
	@Test(dataProvider="getDataforDealCreate")
	public void validateNewDealCreate(String titlevalue, String typeValue, String sourceValue, String statusValue){
		dealsPage = homePage.clickOnNewDealsLink();
		dealsPage.createNewDeal(titlevalue,typeValue,sourceValue,statusValue);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
