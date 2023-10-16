package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import framework.Base;

public class SearchResultsPage extends Base{
	
	private static By search_results_label = By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div[1]/div/div/span/span");
	private static By item_clickable_area = By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a");
	private static By item_name_label = By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[3]/div[1]/div[1]");
	
	
	public static void verifySearchedItem (String item) {
		Assert.assertTrue(getText(search_results_label).contains(item), "User has navigated into correct search results page");
	}
	
	public static void clickItem () {
		click(item_clickable_area);
	}
	
	public static String getFirstItem () {
		return getText(item_name_label);
	}

}
