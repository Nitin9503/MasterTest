package com.Test.com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class demo2 {

	public static void main(String[] args) throws InterruptedException {
		
		   System.setProperty("webdriver.chrome.driver", "E:\\AppiumFile\\chromedriver.exe");
	       WebDriver driver = new ChromeDriver();      
		   //System.setProperty("webdriver.gecko.driver", "E:\\AppiumFile\\geckodriver.exe");
	       // WebDriver driver = new FirefoxDriver();
	       driver.get("https://opensource-demo.orangehrmlive.com/");
	   
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            driver.manage().window().maximize();
	       
	        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	        driver.findElement(By.id("btnLogin")).click();
	        driver.findElement(By.xpath(".//*[@id='menu_admin_viewAdminModule']/b")).click();
	       
	        WebElement element = driver.findElement(By.linkText("User Management"));
	        Actions action = new Actions(driver);
	        action.moveToElement(element).build().perform();
	        driver.findElement(By.linkText("Users")).click();
	        
	        Xls_Reader reader = new Xls_Reader("E:\\Appium1\\com.Test\\src\\main\\java\\com\\testData\\OrangeHrm.xlsx");
	        String userRoll = reader.getCellData("User_Management_data", "User Role", 2);
	        System.out.println(userRoll);
	        
	        String EmployeeName = reader.getCellData("User_Management_data", "Employee name", 2);
	        System.out.println(EmployeeName);
	        
	        String Username = reader.getCellData("User_Management_data", "Username", 2);
	         System.out.println(Username);
	        
	        String Status = reader.getCellData("User_Management_data", "Status", 2);
	        System.out.println(Status);
	        
	        String Password  = reader.getCellData("User_Management_data", "Password ", 2);
	        System.out.println(Password);
	        
	        String ConfirmPassword = reader.getCellData("User_Management_data", "Confirm Password", 2);
	        System.out.println(ConfirmPassword);
	        
	        
	      /*  driver.findElement(By.id("searchSystemUser_userName")).sendKeys("Sachin@Girhepunje");
	        Select Oselect = new Select(driver.findElement(By.id("searchSystemUser_userType")));
	        Oselect.selectByVisibleText("Admin");
	        driver.findElement(By.id("searchSystemUser_employeeName_empName")).sendKeys("Sachin Girhepunje");
	        
	        Select Oselect1 = new Select(driver.findElement(By.id("searchSystemUser_status")));
	        Oselect1.selectByVisibleText("Enabled");*/
	        
	        
	        driver.findElement(By.id("btnAdd")).click();
	        Select Oselect = new Select(driver.findElement(By.id("systemUser_userType")));
	        Oselect.selectByVisibleText(userRoll);
	        
	        driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(EmployeeName);
	        driver.findElement(By.id("systemUser_userName")).sendKeys(Username);
	       // driver.findElement(By.id("btnLogin")).click();
	        
	        Select Oselect1 = new Select(driver.findElement(By.id("systemUser_status")));
	        Oselect1.selectByVisibleText(Status);
	        driver.findElement(By.id("systemUser_password")).sendKeys(Password);
	        driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(ConfirmPassword);
	        driver.findElement(By.id("btnSave")).click();
	        
	       
	        
	        
	        
	        
	      /*  WebElement element = driver.findElement(By.linkText("Job"));
	        Actions action = new Actions(driver);
	        action.moveToElement(element).build().perform();
	        driver.findElement(By.linkText("Pay Grades")).click();*/
	        //driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	        Thread.sleep(3000);
	      //  driver.findElement(By.xpath("//*[@id='header']/div/div/div[1]/div[2]/a")).click();
	       // driver.findElement(By.linkText("//*[.='Try Torenzo For Free']")).click();
	       
	        

	}

}
