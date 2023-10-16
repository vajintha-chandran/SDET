package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import framework.Base;

public class CardPage extends Base{
	
	private static By basket_1st_item_name_link = By.xpath("//a[@class='_2Kn22P gBNbID']");
	
	
	public static void VerifyItem (String item) {
		Assert.assertTrue(getText(basket_1st_item_name_link).contains(item), "System added correct product into card.");
	}

}
