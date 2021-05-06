package com.OrangeHRM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.Utils.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(id="txtUsername")
	WebElement userName;

	@FindBy(id="txtPassword")
	WebElement password;
	
	@FindBy(name="Submit")
	WebElement submitBtn;
	
	@FindBy(xpath="//h1[text()='Dashboard']")
	public WebElement homePage;

	 WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		   PageFactory.initElements(driver, this);
	}

	
	
	public void loginToApp(String username,String pwd) {
		userName.sendKeys(username);
		password.sendKeys(pwd);
		submitBtn.click();
		waitTillElementVisible(driver, homePage);		
	}
}
