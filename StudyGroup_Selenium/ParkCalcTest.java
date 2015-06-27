import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ParkCalcTest {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();
		driver.get("http://adam.goucher.ca/parkcalc");
		driver.manage().window().maximize();

		WebElement wb = driver.findElement(By.id("Lot"));
		// dropdown
		Select sel = new Select(wb);

		sel.selectByValue("VP");

		driver.findElement(By.id("EntryTime")).clear();
		driver.findElement(By.id("EntryTime")).sendKeys("12:00");

		driver.findElement(
				By.xpath("//input[@value='PM' and @name='EntryTimeAMPM']"))
				.click();
		// calendar

		driver.findElement(By
				.xpath("//table/tbody/tr/td/font[input[@id='EntryTime']]/a/img")).click();

		Set<String> windows = driver.getWindowHandles();

		System.out.println(windows.size());
		
		Iterator it = windows.iterator();
		String parentWin = (String) it.next();
		String childWin = (String) it.next();
		
		driver.switchTo().window(childWin);
		
		driver.findElement(By.xpath("//table/tbody/tr[td[font[b[text()='January 2015']]]]/following-sibling::tr/td/font/a[text()='18']")).click();
		System.out.println("clicked");
		
driver.switchTo().window(parentWin);
		
		driver.findElement(By.id("ExitTime")).clear();
		driver.findElement(By.id("ExitTime")).sendKeys("4:00");
		
		driver.findElement(By.xpath("//input[@value='PM' and @name='ExitTimeAMPM']")).click();
		
		driver.findElement(By.xpath("//table/tbody/tr/td/font[input[@id='ExitTime']]/a/img")).click();
		
		Set<String> windCalendar1 = driver.getWindowHandles();
		
		Iterator i1 = windCalendar1.iterator();
		
		String parentWin1 = (String) i1.next();
		String childWin1 = (String) i1.next();
		
		driver.switchTo().window(childWin1);
		
		driver.findElement(By.xpath("//table/tbody/tr[td[font[b[text()='January 2015']]]]/following-sibling::tr/td/font/a[text()='18']")).click();
		System.out.println("clicked1");
		//driver.close();
		driver.switchTo().window(parentWin1);
		
	}

}
