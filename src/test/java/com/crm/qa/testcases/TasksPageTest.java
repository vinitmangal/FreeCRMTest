package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class TasksPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TasksPage taskPage;
	String sheet="D:/Java_training/programms_WS/FreeCRMTest/src/main/java/com/crm/qa/testData/FreeCrmTestData.xlsx";
	
	Logger log = Logger.getLogger(TasksPageTest.class);
	//PropertyConfigurator.configure("log4j.properties");
	
	
	
	public TasksPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		log.info("Logging test1 vinit");
		initialization();
		loginPage = new LoginPage();
		String un = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		System.out.println("un"+un);
		System.out.println("pwd"+pwd);
		homePage = loginPage.login(un, pwd);
		log.info("Logging test1 vinit");
		log.warn("This is Warning");
		log.fatal("This is fatal message");
		log.debug("This is debug message");
	}
	
	//@Test(priority=1)
	public void verifyTaskPageTest(){
		taskPage = homePage.clickOnTaksLink();
		Assert.assertTrue(taskPage.verifyTasksLabel(),"Label 'Showing all tasks' is not getting displayed");
			
	}
	
	@DataProvider
	public Iterator<String[]> getCRMTestData(){
		ArrayList<String[]> datalist=TestUtil.getTasksDataFromExcel(sheet);
		
		for(String[] row:datalist){
			System.out.println(Arrays.toString(row));
		}
		return datalist.iterator();
	}
	
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void validateCreateNewTaskTest(String title,String completion,String task_type,String keyContact,String keyCompany
			,String desc){
		taskPage = homePage.clickOnNewTaksLink();
		taskPage.createNewTask(title,completion,task_type,keyContact,keyCompany,desc);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
