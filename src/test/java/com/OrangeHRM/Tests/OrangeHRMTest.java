package com.OrangeHRM.Tests;

import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.OrangeHRM.PageObjects.HomePage;
import com.OrangeHRM.PageObjects.LoginPage;
import com.OrangeHRM.Utils.BaseClass;


public class OrangeHRMTest extends BaseClass {

	@Test
	public void loginToApp() {
		WebDriver driver=getDriver();
		Random random=new Random();
		String newUserName="haritha"+random.nextInt(24);
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp("Admin", "admin123");
		System.out.println("Logged in");
		Assert.assertEquals(loginPage.homePage.getText(),"Dashboard","Login Failed,home page is not displayed");
		HomePage homePage=new HomePage(driver);
		homePage.clickOnAddUser();
		homePage.createNewuser("Charlie Carter", newUserName, "Vignitha@@2019", "Vignitha@@2019");
		
		 ArrayList<String> listOfUsers=homePage.getListOfUsers();
		 Assert.assertTrue(listOfUsers.contains(newUserName));
		 
		 homePage.logout();
		 loginPage.loginToApp(newUserName, "Vignitha@@2019");
		 Assert.assertEquals(loginPage.homePage.getText(),"Dashboard","Login Failed,home page is not displayed");
		 homePage.logout();
	
	}
}
