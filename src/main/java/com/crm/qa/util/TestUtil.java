package com.crm.qa.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{

	public static long PAGE_LOAD_TIMEOUT = 50;
	public static long IMPLICIT_WAIT = 50;
	static Xls_Reader reader;
	
	public static void switchToFrame(){		
		driver.switchTo().frame(1);
	}
	
	/*public static Object[][] getDataFromExcel(String sheet){
		try{
			reader = new Xls_Reader(sheet);		
		}catch(Exception e){
			e.printStackTrace();
		}
		int rowCount =reader.getRowCount("contactsData")-1;
				
		Object[][] mydata = new Object[rowCount][rowCount];
		int i=0;
		for(int rowNum=2; rowNum<=reader.getRowCount("contactsData");rowNum++){
			
			String title = reader.getCellData("contactsData", "title", rowNum);
					
			String firstName = reader.getCellData("contactsData", "firstname", rowNum);
					
			String lastName = reader.getCellData("contactsData", "lastname", rowNum);
					
			String company = reader.getCellData("contactsData", "company", rowNum);
					
			Object ob[]={title,firstName,lastName,company};
			
			mydata[i] = ob;
			i++;
			
		}
	
		return mydata;
	}*/
	
	
	public static ArrayList<String[]> getDataFromExcel(String sheet){
		try{
			reader = new Xls_Reader(sheet);		
		}catch(Exception e){
			e.printStackTrace();
		}		
		
		ArrayList<String[]> datalist= new ArrayList<String[]>();		
		for(int rowNum=2; rowNum<=reader.getRowCount("contactsData");rowNum++){			
			String title = reader.getCellData("contactsData", "title", rowNum);					
			String firstName = reader.getCellData("contactsData", "firstname", rowNum);					
			String lastName = reader.getCellData("contactsData", "lastname", rowNum);					
			String company = reader.getCellData("contactsData", "company", rowNum);					
			String datarow[]={title,firstName,lastName,company};			
			datalist.add(datarow);			
		}	
		return datalist;
	}
	
	public static ArrayList<String[]> getTasksDataFromExcel(String sheet){
		try{
			reader = new Xls_Reader(sheet);		
		}catch(Exception e){
			e.printStackTrace();
		}		
		
		ArrayList<String[]> datalist= new ArrayList<String[]>();		
		for(int rowNum=2; rowNum<=reader.getRowCount("tasksData");rowNum++){			
			String title = reader.getCellData("tasksData", "title", rowNum);					
			String completion = reader.getCellData("tasksData", "completion", rowNum);					
			String task_type = reader.getCellData("tasksData", "task_type", rowNum);					
			String keyContact = reader.getCellData("tasksData", "key_contact", rowNum);
			System.out.println("keyContact: "+keyContact);
			String keyCompany = reader.getCellData("tasksData", "key_company", rowNum);
			String desc = reader.getCellData("tasksData", "description", rowNum);
			String datarow[]={title,completion,task_type,keyContact,keyCompany,desc};			
			datalist.add(datarow);			
		}	
		return datalist;
	}
	
	public static ArrayList<String[]> getDealsDataFromExcel(String sheet){
		
		reader = new Xls_Reader(sheet);
		ArrayList<String[]> dataList = new ArrayList<String[]>();
		String title;
		String type;
		String source;
		String status;
		System.out.println("Rows"+reader.getRowCount("dealsData"));
		
		for(int rowNum=2; rowNum<=reader.getRowCount("dealsData");rowNum++){
			 title = reader.getCellData("dealsData", "title", rowNum);
			 
			 type = reader.getCellData("dealsData", "type", rowNum);
			 
			 source = reader.getCellData("dealsData", "source", rowNum);
			 
			 status = reader.getCellData("dealsData", "status", rowNum);
			 
			 String[]  rowdata = {title,type,source,status};
			// System.out.println(Arrays.toString(rowdata));
			 
			 dataList.add(rowdata);
			 
		}
		return dataList;
	}
	public static void takeScreenShot() throws IOException{
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		System.out.println("currentDir" + currentDir);
		
		FileUtils.copyFile(srcFile, new File((currentDir + "/screenshots/" + System.currentTimeMillis() + ".png")));
	}
	
}
