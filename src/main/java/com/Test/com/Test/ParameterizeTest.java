package com.Test.com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class ParameterizeTest {
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
		 int rowCount=reader.getRowCount("User_Management_data");
		 for(int rowNum=2; rowNum<=rowCount; rowNum++)
		 {
			    driver.findElement(By.id("btnAdd")).click();
			    String userRoll = reader.getCellData("User_Management_data", "User Role", rowNum); 
			    System.out.println(userRoll);
			    
			    String EmployeeName = reader.getCellData("User_Management_data", "Employee name", rowNum);
		        System.out.println(EmployeeName);
		        
		        String Username = reader.getCellData("User_Management_data", "Username", rowNum);
		         System.out.println(Username);
		        
		        String Status = reader.getCellData("User_Management_data", "Status", rowNum);
		        System.out.println(Status);
		        
		        String Password  = reader.getCellData("User_Management_data", "Password ", rowNum);
		        System.out.println(Password);
		        
		        String ConfirmPassword = reader.getCellData("User_Management_data", "Confirm Password", rowNum);
		        System.out.println(ConfirmPassword);
		        
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
		 }

	}
}