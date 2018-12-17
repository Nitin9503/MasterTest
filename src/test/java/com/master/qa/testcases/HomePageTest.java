package com.master.qa.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.master.qa.base.TestBase;
import com.master.qa.pages.HomePage;
import com.master.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
	    loginPage = new LoginPage();
	    homePage = new HomePage(); 
	    loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	    Thread.sleep(2000);
	    driver.get(prop.getProperty("departUrl"));
	    Thread.sleep(2000);
	}
	
	@Test(priority=1)
	public void DepaPageTitleTest() throws InterruptedException{
		Thread.sleep(3000);
		String dpartTitle= homePage.validateDepaPageTitle();
		System.out.println(dpartTitle);
		Assert.assertEquals(dpartTitle,"Departments","deaprtment Tiltle not found");
		
		
	}
	@Test(priority=2)
	public void DepartTextTest() throws InterruptedException{
		Thread.sleep(2000);
		boolean flag =homePage.validateDepartText();
		System.out.println(flag);
		Assert.assertTrue(flag);
		
		
	}
	@Test(priority=3)
	public void addNewdepaTest(){
		homePage.validateNewDepart();
		
	}
	@AfterTest
	public void tearDown(){
		driver.close();
	}
	
}
