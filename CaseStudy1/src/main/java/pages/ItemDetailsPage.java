package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import framework.Base;

public class ItemDetailsPage extends Base {
	
	private static By details_page_item_name_label = By.xpath("//*[@id='container']/div/div[3]/div[1]/div[2]/div[3]/div/div[1]/h1/span");
	private static By Add_to_Card_button = By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
	private static By card_icon = By.xpath("//a[@class='_3SkBxJ']");
	
	
	public static void VerifyItem (String item) {
		Assert.assertTrue(getText(details_page_item_name_label).contains(item), "System displays correct product details");
	}
	
	
	public static void clickAddToCard () {
		click(Add_to_Card_button);
	}
	
	public static void clickCardIcon () {
		click(card_icon);
	}

}
