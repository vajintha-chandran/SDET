package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import framework.Base;

public class HomePage extends Base {
	
	private static By nameInLogo = By.xpath("//img[@class='aqQN50']");
	private static By loginPoPupCloseButton = By.xpath("/html/body/div[3]/div/span");
	private static By searchTextbox = By.xpath("//input[@name='q']");
	private static By searchicon = By.xpath("//*[@id=\"container\"]/div/div[1]/div/div/div/div/div[1]/div/div[1]/div/div[1]/header/div[1]/div[2]/form/div/button");
	
	
	public static void closeLoginPoP () {
		click(loginPoPupCloseButton);
	}
	
	public static void verifyPage() {
		Assert.assertTrue(getAttributeValue(nameInLogo).equals("Flipkart"), "User has navigated into flipkart home page");	
	}
	
	public static void search(String text) {
		type(searchTextbox, text);
		click(searchicon);
	}
	

}
