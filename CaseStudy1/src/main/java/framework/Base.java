package framework;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Base {
	
	public static WebDriver driver;
	
	
	public static void open_driver(String browserName ){
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",".//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	
	public static void close_browser() {
		if(driver!=null)
			driver.quit();
	}
	
	public static String getAttributeValue(By element) {
		return driver.findElement(element).getAttribute("title");
	}
  
	
	public static void navigate_to_URL(String url) {
		driver.get(url);
	}
	
	public static void switch_tab() {
        //driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
		String currentTab = driver.getWindowHandle();
		for (String tab : driver.getWindowHandles()) {
		    if (!tab.equals(currentTab)) {
		        driver.switchTo().window(tab); 
		    }       
		}
	}
		

	public static void click(By element) {
		try {
			driver.findElement(element).click();
		} catch(ElementNotInteractableException e) {
			driver.findElement(element).click();
		}
	}
	
	public static String getText(By element) {
		return driver.findElement(element).getText();
	}
	
	public static void type(By element, String value) {
		driver.findElement(element).sendKeys(value);
	}

}
