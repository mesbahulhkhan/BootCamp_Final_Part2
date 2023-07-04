package com.tn.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tn.utils.Utilities;

public class TestBase {
	public WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	public FileInputStream ip;
	public FileInputStream idatap;
	
public TestBase() throws Exception {
		prop = new Properties();
		try {
			ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\tn\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	    dataProp = new Properties();
	    try {
			idatap = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\tn\\testData\\testdata.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	    try {
			dataProp.load(idatap);
		} catch (IOException e) {
			e.printStackTrace();
		}
}	
	
	public WebDriver openApplication(String browserName) {
		if(browserName.equals("Chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equals("Edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_lOAD_TIMEOUT));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utilities.SCRIPT_TIMEOUT));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
}
