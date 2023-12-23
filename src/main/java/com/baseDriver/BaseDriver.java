package com.baseDriver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriver {
	
	private static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	public static WebDriver  initializeBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			tdriver.set(new ChromeDriver());
		}else if(browser.equalsIgnoreCase("firefox")) {
			tdriver.set(new FirefoxDriver());
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		
		return getDriver();
	}
	
	public static WebDriver getDriver() {
		return tdriver.get();
	}
	

	
	
}
