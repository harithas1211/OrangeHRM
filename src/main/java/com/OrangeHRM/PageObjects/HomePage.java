package com.OrangeHRM.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.Utils.BaseClass;

public class HomePage extends BaseClass{
	
	 WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		   PageFactory.initElements(driver, this);
	}
	
@FindBy(id="menu_admin_viewAdminModule")
WebElement adminSection;

@FindBy(id="menu_admin_UserManagement")
WebElement userManagement;

@FindBy(id="menu_admin_viewSystemUsers")
WebElement addUserLink;

@FindBy(id="btnAdd")
WebElement addBtn;
@FindBy(id="systemUser_employeeName_empName")
WebElement empName;
@FindBy(id="systemUser_userName")
WebElement userName;
@FindBy(id="systemUser_password")
WebElement password;
@FindBy(id="systemUser_confirmPassword")
WebElement ConfirmPwd;
@FindBy(xpath="//input[@value='Save']")
WebElement saveBtn;
@FindBy(xpath="//table[@id='resultTable']/tbody/tr/td[2]/a")
List<WebElement> listOfNames;

@FindBy(className ="panelTrigger")
WebElement logoutMenu;
@FindBy(xpath="//div/ul/li/a[text()='Logout']")
WebElement logoutBtn;

public void logout() {
	logoutMenu.click();
	waitTillElementVisible(driver, logoutBtn);
	logoutBtn.click();
}
public void createNewuser(String employeeName, String userNameText, String pwdText, String confirmPwd1) {
	addBtn.click();
	empName.sendKeys(employeeName);
	userName.sendKeys(userNameText);
	password.sendKeys(pwdText);
	ConfirmPwd.sendKeys(confirmPwd1);
	waitTillElementVisible(driver, saveBtn);
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	saveBtn.click();
	//saveBtn.submit();
	JavascriptExecutor executor = (JavascriptExecutor)driver; 
	executor.executeScript("arguments[0].click();", saveBtn);
	executor.executeScript("arguments[0].click();", saveBtn);
	executor.executeScript("arguments[0].click();", saveBtn);
	//saveBtn.submit();
	waitTillElementVisible(driver, addBtn);
}


public void clickOnAddUser() {
	Actions act=new Actions(driver);
	act.moveToElement(adminSection).build().perform();
	act.moveToElement(userManagement).build().perform();
	addUserLink.click();
	waitTillElementVisible(driver, addBtn);
	
	
}

public ArrayList<String> getListOfUsers() {
	ArrayList<String> listOfStrings=new ArrayList<String>();
	for(int i=0;i<listOfNames.size();i++) {
		
		listOfStrings.add(listOfNames.get(i).getText());
			
	}
	return listOfStrings;
}

}
