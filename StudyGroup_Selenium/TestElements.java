import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class TestElements {
	
	public static void main(String[] args) throws InterruptedException{
		
		
		//for drag and drop and frame
		
		WebDriver driver = new FirefoxDriver();
		/*
		driver.get("http://the-internet.herokuapp.com/drag_and_drop");
		
		WebElement wb1 = driver.findElement(By.id("column-a"));
		WebElement wb2 = driver.findElement(By.id("column-b"));
		
		Actions builder = new Actions(driver);  // Configure the Action  
		  Action dragAndDrop = builder.clickAndHold(wb1)  
		    .moveToElement(wb2)  
		    .release(wb2)  
		    .build();  // Get the action  
		    dragAndDrop.perform(); // Execute the Action  
		
		Thread.sleep(5000);
		*/
		
		driver.get("http://jqueryui.com/droppable/");  
		driver.manage().window().maximize();
		WebElement wb = driver.findElement(By.xpath("//iframe[@class = 'demo-frame']"));
		  driver.switchTo().frame(wb);    
		  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);  
		  WebElement dragElement=driver.findElement(By.id("draggable"));  
		  WebElement dropElement=driver.findElement(By.id("droppable"));  
		      
		  Actions builder = new Actions(driver);  // Configure the Action  
		  Action dragAndDrop = builder.clickAndHold(dragElement)  
		    .moveToElement(dropElement)  
		    .release(dropElement)  
		    .build();  // Get the action  
		    dragAndDrop.perform(); // Execute the Action  
		 
		    //driver.quit();
		
	}

}
