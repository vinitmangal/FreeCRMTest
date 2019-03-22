package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.EventListener;
import com.crm.qa.util.TestUtil;

public class TestBase{
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase(){
		prop = new Properties();
		
		try {
			FileInputStream ip = new FileInputStream("D:/Java_training/programms_WS/FreeCRMTest1/src/main/"
					+ "java/com/crm/qa/config/config.properties");			
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:/Automation/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver","D:/Automation/geckodriver-v0.19.0-win64/geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		/*EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
		e_driver.register(new EventListener());		
		driver = e_driver;*/
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
