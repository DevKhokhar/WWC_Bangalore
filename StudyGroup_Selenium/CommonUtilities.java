import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class CommonUtilities {
	
	public boolean existsElement(String xpath , WebDriver driver) {
	    try {
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.findElement(By.xpath(xpath));
	        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	        return true;
	    } catch (Exception e) {
	    	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
	        return false;
	    }
	}
	
	public void selectFromList(String xpathOfListItems, String valueToSelect, WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(4000);
    	List<WebElement> items=driver.findElements(By.xpath(xpathOfListItems));
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	if(driver.findElements(By.xpath(xpathOfListItems)).size()<2){
    		System.out.println("Still refreshing list");
			Thread.sleep(20000);
		}
    	driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
    	System.out.println("Done refreshing list");
    	boolean exists=false;
    	for(WebElement elem:items){
    		System.out.println(elem.getText()+":"+valueToSelect);
    		if(elem.getText().equalsIgnoreCase(valueToSelect)){
    			exists=true;
    			elem.click();
    			break;
    		}
    	}
		Assert.assertTrue(exists);
	}
	
	
	public void selectFromSelect(String valueToSelect,WebElement select,String selectBy){
		Select option=new Select(select);
		if(selectBy.length()==0 || selectBy.equalsIgnoreCase("visibletext")){
			option.selectByVisibleText(valueToSelect);
		}
		else if(selectBy.equalsIgnoreCase("index")){
			option.selectByIndex(Integer.parseInt(valueToSelect));
		}
		else if(selectBy.equalsIgnoreCase("value")){
			option.selectByValue(valueToSelect);
		}
	}
	
	
	public boolean getAndVerifyText(String loc , String expectedVal, WebDriver driver){
		
		boolean status = false;
		String actualVal = driver.findElement(By.xpath(loc)).getText();
		
		if(actualVal.equalsIgnoreCase(expectedVal))
			status = true;
		
		return status;
		
		
	}
}
