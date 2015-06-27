import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;


public class demo {
	
	public static void main(String[] args){
		
		WebDriver driver = new FirefoxDriver();
		//handle alerts
		Alert alt = driver.switchTo().alert();
		alt.accept();
		alt.dismiss();
		
		
		//handle proxy
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.http", "localhost/IP");
		profile.setPreference("network.proxy.http-port", 3128);
		
		
		//brwser action
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();
		
		
		
		driver.getCurrentUrl();
		
		driver.getClass();
		
	}

}


