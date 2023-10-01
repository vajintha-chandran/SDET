package Questions3and4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Basic_utilities {
	
	public static WebDriver driver;
	
	
	public static void open_driver(String browserName ){
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",".//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}	
	
	
	
	public static void close_browser() {
		if(driver!=null)
			driver.quit();
	}
	
	
	
	public static void navigate_to_URL(String url) {
		driver.get(url);
	}
	
	
	
	public static void navigate_back() {
		driver.navigate().back();
	}

	
	
	public static boolean is_displayed(By element) {
		try {
			return driver.findElement(element).isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	
	
	public static boolean is_enabled(By element) {
		try {
			return driver.findElement(element).isEnabled();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	
	public static void scroll_browser(int horizontal, int vertical) {
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollBy("+horizontal+","+vertical+")", "");
			Thread.sleep(3000);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void scroll_to_element(By element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void click(By element) {
		try {
			driver.findElement(element).click();
		} catch(ElementNotInteractableException e) {
			
			scroll_to_element(element);
			driver.findElement(element).click();
		}
	}
	
	
	public static String get_current_url() {
		return driver.getCurrentUrl();
	}

}
