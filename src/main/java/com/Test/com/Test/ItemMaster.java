package com.Test.com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ItemMaster {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\AppiumFile\\chromedriver.exe");
	       WebDriver driver = new ChromeDriver();      
		   //System.setProperty("webdriver.gecko.driver", "E:\\AppiumFile\\geckodriver.exe");
	       // WebDriver driver = new FirefoxDriver();
	       driver.get("http://192.168.1.142:8080/TorenzoPOS/login.jsp");
	   
         driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
         driver.manage().window().maximize();
        
        String loginText= driver.findElement(By.xpath("//h1[text()='Login']")).getText();
        System.out.println(loginText);
         driver.findElement(By.id("usernm")).sendKeys("torenzocafe");
         driver.findElement(By.id("pwd")).sendKeys("1234");
       
         driver.findElement(By.xpath("//button[@type='submit']")).click();
        // driver.findElement(By.xpath(".//*[@id='loginForm']/button")).click();
         Thread.sleep(2000);
         driver.get("http://192.168.1.142:8080/TorenzoPOS/department.jsp");
         Thread.sleep(3000);
         String st=driver.getTitle();
         System.out.println(st);
         
         driver.findElement(By.id("addNew")).click();
         Thread.sleep(3000);
         int depaSize=driver.findElements(By.xpath("//div[@id='departmentMainGrid']//tbody/tr")).size();
         System.out.println(depaSize);
         driver.findElement(By.xpath("//div[@id='deptInfo']/div[@id='first']/p/input")).click();
         driver.findElement(By.xpath("//div[@id='deptInfo']/div[@id='second']/p/input")).sendKeys("onion");
         driver.findElement(By.xpath("//div[@id='deptInfo']/div[@id='third']/p/input")).sendKeys("onion");
         Thread.sleep(3000);
         driver.findElement(By.xpath("//div[@id='Department']//span[contains(text(), 'Save and New')]")).click();
         Thread.sleep(3000);
         int depaSize1=driver.findElements(By.xpath("//div[@id='departmentMainGrid']//tbody/tr")).size();
         System.out.println(depaSize1);
         Assert.assertEquals(depaSize1, depaSize+1, "department not added in department list");
         System.out.println("department added successfully");
         //div[@id='deptInfo']/div[@id='second']/p/input
         /*driver.findElement(By.xpath("//div[@id='categoryInfo']/div[@id='second']/p/input")).sendKeys("onion");
         driver.findElement(By.xpath(".//*[@id='third']/p/input")).sendKeys("onion");*/
         Thread.sleep(3000);
         String windowTitle=driver.findElement(By.id("Category_wnd_title")).getText();
         System.out.println(windowTitle);
         Thread.sleep(3000); 
         //driver.findElement(By.xpath("html/body/div[8]/div[1]/div")).click();
         /*driver.findElement(By.name("Item Number")).sendKeys("D00001");
         driver.findElement(By.name("ItemSearchCode")).sendKeys("I00001");
         driver.findElement(By.name("fblink")).sendKeys("item@facebook.com");
         driver.findElement(By.name("BarcodeNumber")).sendKeys("B00001");
         driver.findElement(By.xpath(".//*[@id='leftsectionthird']/p/input")).sendKeys("onion"); 
         driver.findElement(By.xpath(".//*[@id='leftsectionfourth']/p/textarea")).sendKeys("onion paratha");
         driver.findElement(By.xpath(".//*[@id='rightsectionfirst']/p/input")).click();
        
         driver.findElement(By.xpath(".//*[@id='rightsectionsecond']/p/span/span/span[2]/span")).click();
        // Select Oselect = new Select(driver.findElement(By.id("data-value-field")));
        // Oselect.selectByVisibleText("Noninventory");
         driver.findElement(By.xpath("html/body/div[38]/div/ul/li[2]")).click();
         driver.findElement(By.xpath(".//*[@id='rightsectionthird']/p/button")).click();
        // driver.findElement(By.xpath("//td[contains(text(),'Food')]")).click();
         *    
         
         */
         //driver.findElement(By.xpath("//input[@class='k-checkbox']")).click();
         //driver.findElement(By.xpath(".//*[@id='DepartmentGrid']/div[3]/table/tbody/tr[1]/td[3]")).click();
         Thread.sleep(3000);
         //driver.findElement(By.id("searchKey")).sendKeys("D00001");
        // driver.findElement(By.name("code")).sendKeys("D00001");
         //driver.findElement(By.xpath(".//*[@id='first']/p/input")).click();
         Thread.sleep(3000);
         driver.findElement(By.xpath("html/body/div[8]/div[1]/div/a")).click();
         
        Thread.sleep(3000);
        WebElement element =driver.findElement(By.xpath("//*[@id='second']/p/input"));
        element.click();
        element.sendKeys("D00002");
        //input[@name='code' and @class='k-textbox k-invalid'].c
        //input[@class='k-textbox' and @name='Name' and @type='text']
         System.out.println("Done arj");
         
         driver.findElement(By.xpath(".//*[@id='third']/p/input")).sendKeys("D00003");
         // driver.findElement(By.xpath("//input[@value='OK']")).click();
         driver.findElement(By.xpath("//input[contains(@value,'OK')]")).click();
         //*[@id='DepartmentGrid']/div[3]/table/tbody/tr[1]/td[3]
         //Oselect.selectByIndex(2);
      
         
         

	}

}
