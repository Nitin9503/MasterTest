package com.Test.com.Test;

import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
           String st=driver.getTitle();
           System.out.println(st);
           // driver.findElement(By.xpath(".//*[@id='loginForm']/button")).click();
         Thread.sleep(2000);
         driver.get("http://192.168.1.142:8080/TorenzoPOS/item.jsp");
         //driver.get("http://192.168.1.142:8080/TorenzoPOS/category.jsp");
         //driver.get("http://192.168.1.142:8080/TorenzoPOS/department.jsp");
         Thread.sleep(3000);
         String st1 =driver.getTitle();
         System.out.println(st1);
         
         
         
         
         
        
         //categories details
        /* int depaSize=driver.findElements(By.xpath("//div[@id='CategoryGrid']//tbody/tr")).size();
         System.out.println(depaSize);
         Thread.sleep(3000);
         driver.findElement(By.id("NewCategory")).click();
         Thread.sleep(3000); 
         String windowTitle=driver.findElement(By.id("Category_wnd_title")).getText();
         System.out.println(windowTitle);
         driver.findElement(By.xpath("//input[@type='checkbox']")).click();
         driver.findElement(By.xpath("//div[@id='categoryInfo']/div[@id='second']/p/input")).sendKeys("100001");
         driver.findElement(By.xpath(".//*[@id='third']/p/input")).sendKeys("onion");
         Thread.sleep(3000); 
         driver.findElement(By.xpath("//button[@type='button' and text()='Browse']")).click();
         Thread.sleep(3000); 
         //driver.findElement(By.xpath("//div[@id='DepartmentListGrid']//td[text()='Food']")).click();
         for(int i=1; i<=10; i++){
        	 System.out.println("it enter into for loop "+i);
        	 try {
				if(driver.findElement(By.xpath("//div[@id='DepartmentListGrid']//td[text()='Food4']")).isDisplayed()){
					System.out.println("it enter into try block");
					driver.findElement(By.xpath("//div[@id='DepartmentListGrid']//td[text()='Food4']")).click();
					break;
				 }
				
			} catch (Exception e) {
				    System.out.println("it enter into try block");
				    driver.findElement(By.xpath("//*[@id='DepartmentListGrid']/div[3]/a[3]")).click();
                    //e.printStackTrace();
			}
        	 
         }
         driver.findElement(By.xpath("//input[@type='button' and @value='OK']")).click();
         driver.findElement(By.xpath("//span[text()='Save and Close']")).click();
         driver.findElement(By.xpath("//button[@class='alert-confirm k-button']")).click();
         driver.findElement(By.xpath("html/body/div[7]/div[1]/div/a/span")).click();
         driver.findElement(By.xpath("//button[@class='save-cancel k-button']")).click();
         System.out.println("click on not save button");
        */
         
         /*
         // Switching to Alert  html/body/div[7]/div[1]/div/a/span      
         Alert alert = driver.switchTo().alert();		
         // Capturing alert message.    
         String alertMessage= driver.switchTo().alert().getText();		
         // Displaying alert message		
         System.out.println(alertMessage);	
         Thread.sleep(5000);
         // Accepting alert		
         alert.accept();*/
         
         //Department Details
         /* 
         Thread.sleep(3000);
         int depaSize=driver.findElements(By.xpath("//div[@id='departmentMainGrid']//tbody/tr")).size();
         System.out.println(depaSize);
         driver.findElement(By.id("addNew")).click();
         String windowTitle=driver.findElement(By.id("Department_wnd_title")).getText();
         System.out.println(windowTitle);
         driver.findElement(By.xpath("//div[@id='deptInfo']/div[@id='first']/p/input")).click();
         driver.findElement(By.xpath("//div[@id='deptInfo']/div[@id='second']/p/input")).sendKeys("onion");
         driver.findElement(By.xpath("//div[@id='deptInfo']/div[@id='third']/p/input")).sendKeys("onion");
         Thread.sleep(3000);
         driver.findElement(By.xpath("//div[@id='Department']//span[contains(text(), 'Save and Close')]")).click();
         Thread.sleep(3000);
         driver.findElement(By.xpath("//button[@class='alert-confirm k-button']")).click();
         Thread.sleep(3000); 
         int depaSize1=driver.findElements(By.xpath("//div[@id='departmentMainGrid']//tbody/tr")).size();
         System.out.println(depaSize1);
         Assert.assertEquals(depaSize1, depaSize+1, "department not added in department list");
         System.out.println("department added successfully");
         */
         //div[@id='deptInfo']/div[@id='second']/p/input
         
         
         //Thread.sleep(3000); 
         //driver.findElement(By.xpath("html/body/div[8]/div[1]/div")).click();
         driver.findElement(By.xpath("//input[@id='addNew' and @onclick='addNewItem()']")).click();
         driver.findElement(By.name("Item Number")).sendKeys("D00001");
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
         driver.findElement(By.xpath("//div[@id='rightsectionthird']//button[text()='Browse']")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//div[@id='DepartmentGrid']//span[text()='select']")).click();
         Thread.sleep(2000);
         //driver.findElement(By.xpath("//span[@class='k-input' and text()='5']")).click();
         
         
          driver.findElement(By.xpath("html/body/div[62]/div/ul/li[1]")).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath("//div[@id='DepartmentGrid']//a[@title='Go to the next page' and @class='k-link k-pager-nav']")).click();
          Thread.sleep(2000);
          driver.findElement(By.xpath("//div[@id='DepartmentGrid']//a[@title='Go to the previous page' and @class='k-link k-pager-nav']")).click();
          // driver.findElement(By.xpath("//div[@id='DepartmentGrid']//select[@data-role='dropdownlist']")).click();
         //div[@id='DepartmentGrid']//span[@unselectable='on']//select[@data-role='dropdownlist']
         // Select Oselect = new Select(driver.findElement(By.xpath(".//*[@id='DepartmentGrid']/div[4]/span[1]/span/span")));
         //Oselect.selectByValue("5");
         //span[@class='k-input' and text()='5']
         // drp.selectByValue("5")
         Thread.sleep(2000);
         driver.findElement(By.xpath("//div[@id='DepartmentGrid']//td[text()='Beverage1']")).click();
         driver.findElement(By.xpath("//input[@onclick='selectDepartment()']")).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath("//div[@id='rightsectionfourth']//button[text()='Browse']")).click();
         Thread.sleep(1000);
         driver.findElement(By.xpath("//td[text()='Ice_Cream1']")).click();
         //driver.findElement(By.xpath("//div[@id='categoryGrid']//td[text()='Ice_Cream1']")).click();
         Thread.sleep(1000);
         driver.findElement(By.xpath("//input[@onclick='selectCategory()']")).click();
         System.out.println("Done arj");
         Thread.sleep(1000);
       
         driver.findElement(By.xpath("//div[@id='PriceAndCostForItem']//div[@id='rightsectionsix']//input[@type='text' and @style='width: 55%' and @class='k-textbox']")).sendKeys("500");
         driver.findElement(By.xpath("//div[@id='PriceAndCostForItem']//div[@id='rightsectionseven']//input[@type='text' and @style='width: 55%' and @class='k-textbox']")).sendKeys("450");
         Thread.sleep(3000);
        /* JavascriptExecutor js = (JavascriptExecutor) driver;
         //This will scroll the web page till end.
         WebElement Element = driver.findElement(By.xpath("//img[@id='ItemPicture' and @src='resources/ItemsImages/item_logo.jpg' and @style='margin-left:150px']"));
         //This will scroll the page till the element is found		
         js.executeScript("arguments[0].scrollIntoView();", Element);
          Thread.sleep(2000);
       */  
      driver.findElement(By.xpath("//div[@id='Item']//span[text()='Save and Close']")).click();
        
        //  driver.findElement(By.xpath("//div[@id='rightsectionnine']//input[@type='text' and @style='width: 55%' and @class='k-textbox']")).sendKeys("4000");;
      
    
     
         //div[@id='rightsectionnine']//input[@type='text' and @style='width: 55%' and @class='k-textbox']
         //div[@id='rightsectionnine']//input[@type='text' and @style='width: 55%' and @class='k-textbox'] //driver.findElement(By.xpath(".//*[@id='DepartmentGrid']/div[3]/table/tbody/tr[1]/td[3]")).click();
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
