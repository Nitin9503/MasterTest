package com.master.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.master.qa.base.TestBase;
import com.master.qa.pages.HomePage;
import com.master.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
	    loginPage = new LoginPage(); 
	}
	
	/*@Test(priority=1)
	public void loginPageTitleTest(){
		String title =loginPage.validateLoginPageTitle();
		//Assert.assertEquals(title, "http://192.168.1.142:8080/TorenzoPOS/login.jsp");
		System.out.println(title);
	}*/
	
	@Test(priority=1)
	public void loginLogoTest(){
		String title =loginPage.validateLoginPageLogo();
		Assert.assertEquals(title, "Login");
		System.out.println(title);
	}
	@Test(priority=2)
	public void loginLogoTest1(){
		boolean flag =loginPage.validateLoginImage();
		Assert.assertTrue(flag);
	
	}
	//@Test(priority=3)
	public void loginTest() throws InterruptedException{
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	

}
