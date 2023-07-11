package com.emp.qa.basetest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Basetest { //parent class
	public static WebDriver driver;
	public static Properties prop;    //2-global variables..
	
	public Basetest() throws IOException // constructor
	{ 
	
		try {  // to handle the exceptions 
			prop= new Properties(); // new object for properties
			FileInputStream file = new FileInputStream("/Users/goutamraju/Desktop/Java/Empirehomeporject/src/main/java/com/emp/qa/config/config.properties");
			prop.load(file);	// for opening the file	
		} 
		
		catch (FileNotFoundException e) // if file not found message will be shown
		{
			e.printStackTrace();
		}
			
	}
	public static void initialization() { // new method for opening browser
		String browser = prop.getProperty("browsername");
		
		if (browser .equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/goutamraju/Desktop/Drivers/chromedriver_mac_arm64/chromedriver");
			driver = new ChromeDriver();
		}
		else if (browser.equals("FireFox")) {
			driver = new FirefoxDriver();
		}
		else 
			System.out.println("no broswer found");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait (20, TimeUnit. SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
