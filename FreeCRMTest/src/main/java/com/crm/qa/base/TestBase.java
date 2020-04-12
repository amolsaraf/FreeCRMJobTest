package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
			 
		 try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("E:\\Eclipse\\workpsace\\FreeCRMTest\\src\\main\\java\\com\\crm"
			 		+ "\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
			 e.printStackTrace();
		 }
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Work Documents\\Selenium\\Working Drivers\\New 80\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "E:\\Work Documents\\Selenium\\Working Drivers\\New 80\\chromedriver_win32\\chromedriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);  //TestUtil is fetched from TestUtil class created in Util package and hence not hardcoded.
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS); //TestUtil is fetched from TestUtil class created in Util package and hence not hardcoded.
		
		driver.get(prop.getProperty("url"));
	}
		 
		 
		 
		 
		 
		 
	
}
