import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ActiTime {
	
public static void main(String[] args) throws InterruptedException{
		
	//multiple window handles and wait
	
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://online.actitime.com/qubole");
		
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
		waitForPageToLoad(driver, wait);
		
		driver.findElement(By.id("username")).sendKeys("monika_khandelwal16");
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("AHUdurYs");
		
		WebElement loginBtn = driver.findElement(By.id("loginButton"));
		loginBtn.click();
		waitForPageToLoad(driver, wait);
		
		/*
		driver.findElement(By.xpath("//div[@id='container']/form[1]/table/tbody/tr/td/table[1]/tbody/tr[3]/td[1]/table/tbody/tr/td[6]/a/img")).click();
		Thread.sleep(3000);
		
        Set<String> windCalendar = driver.getWindowHandles();
		
		Iterator i = windCalendar.iterator();
		System.out.println(windCalendar.size());
		String parentWin = (String) i.next();
		String childWin = (String) i.next();
		
		driver.switchTo().window(childWin);
		
		WebElement wb = driver.findElement(By.xpath(".//select[@class = 'customer-project-select' and @name='customerId']"));
		
		Select sel = new Select(wb);
		sel.selectByValue("2");
		
WebElement wb1 = driver.findElement(By.xpath(".//select[@class = 'customer-project-select' and @name='projectId']"));
		
		Select sel1 = new Select(wb1);
		sel1.selectByValue("3");
		
		driver.findElement(By.id("task[0].name")).sendKeys("demo");
		driver.findElement(By.xpath("//input[@class = 'hierarchy_element_wide_button']")).click();
		
		Thread.sleep(3000);
		
		*/
		
		//click on getting started
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class = 'hlink hlinkbig' and text() = 'Getting Started']")));
		
		WebElement wb = driver.findElement(By.xpath("//a[@class = 'hlink hlinkbig' and text() = 'Getting Started']"));
		if(wb.isDisplayed())
		wb.click();
		
        Thread.sleep(3000);
		
        Set<String> windCalendar = driver.getWindowHandles();
		
		Iterator i = windCalendar.iterator();
		System.out.println(windCalendar.size());
		String parentWin = (String) i.next();
		String childWin = (String) i.next();
		
		driver.switchTo().window(childWin);
		driver.close();
		
		driver.switchTo().window(parentWin);
		
		//logout
		driver.findElement(By.id("logoutLink")).click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("loginButton")));
		driver.quit();
		
}


public static void waitForPageToLoad(WebDriver driver,WebDriverWait wait) {
    ExpectedCondition<Boolean> pageLoadCondition = new
        ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        };
    wait.until(pageLoadCondition);
}

}
