package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	//OR
	WebDriver driver;
	
//	@FindBy(id="")
//	WebElement email;
	
	By emailById = By.id("email");
	
	By passwordByiD = By.id("pass");
	
	By loginBtnByxpath = By.xpath("//button[@id='send2']");
	
	By errorCode  = By.xpath("//li[@class='error-msg']//ul//li");
	
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
	}
	
	public String getPagetitle() {
		return driver.getTitle();
	}
	
	public void sendEmailId(String useremail) {
		driver.findElement(emailById).sendKeys(useremail);
	}
	
	public void sendPassword(String password) {
		driver.findElement(passwordByiD).sendKeys(password);
	}
	
	public void clickOnLoginBtn() {
		driver.findElement(loginBtnByxpath).click();
	}
	
	public String getloginError() {
		return driver.findElement(errorCode).getText();
	}
}
