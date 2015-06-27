import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ExportReport extends BookingTest{
	public static void main(String[] args) throws InterruptedException{
		
		String downloadDir=makeDownloadsDirectory("test");
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.folderList",2);
        profile.setPreference("browser.download.manager.showWhenStarting",false);
        profile.setPreference("browser.helperApps.alwaysAsk.force", false);
        profile.setPreference("browser.download.dir",downloadDir);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/xml, text/csv, text/plain, text/log, application/zlib, application/x-gzip, application/x-compressed, application/x-gtar, multipart/x-gzip, application/tgz, application/gnutar, application/x-tar, application/gzip");
	WebDriver driver = new FirefoxDriver(profile);
	
	driver.get("https://online.actitime.com/qubole");
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	WebDriverWait wait = new WebDriverWait(driver, 100);
	waitForPageToLoad(driver, wait);
	
	driver.findElement(By.id("username")).sendKeys("monika_khandelwal16");
	driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("AHUdurYs");
	
	WebElement loginBtn = driver.findElement(By.id("loginButton"));
	loginBtn.click();
	waitForPageToLoad(driver, wait);
	
	//go to report page

	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class = 'content reports']/img")));
	driver.findElement(By.xpath("//a[@class = 'content reports']/img")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@id='reportConfig_42']/tr/td[@class = 'content-cell']/div")).click();
	
	((JavascriptExecutor)driver).executeScript("scrollTo(0,3000)");
	
	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("exportToCsv")));
	
	driver.findElement(By.id("exportToCsv")).click();
	
	}
	
	 protected static String makeDownloadsDirectory(String folder_name){
	    	
	    	String newFolder=System.getProperty("user.home");
	    		newFolder+="/TempDown_"+folder_name;
	    	
	    	try {
	            File f = new File(newFolder);
	            if(!f.exists()){
	            	FileUtils.forceMkdir(f); //create directory
	            }
	            return newFolder;
	        } catch (IOException e) {
	            e.printStackTrace();
	            return newFolder;
	        } 
	    }

}
