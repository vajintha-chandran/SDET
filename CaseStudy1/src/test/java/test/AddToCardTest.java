package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import framework.Base;
import pages.HomePage;
import pages.SearchResultsPage;
import pages.ItemDetailsPage;
import pages.CardPage;


public class AddToCardTest extends Base{
	
	HomePage homepage;
	SearchResultsPage searchResultPage;
	ItemDetailsPage detailsPage;
	CardPage cardpage;
	
	@BeforeSuite
	public void setup() {
		open_driver("chrome");
		navigate_to_URL("https://www.flipkart.com/");
		homepage.closeLoginPoP();
		homepage.verifyPage();
	}
	
		
	@Test(priority=1)
	public void searchProduct(){
		homepage.search("Macbook air m2");	
		searchResultPage.verifySearchedItem("Macbook air m2");
		
	}
	
	@Test(priority=2)
	public void clickFirstItem(){
		searchResultPage.clickItem();
		String item_name = searchResultPage.getFirstItem();
		switch_tab();
		detailsPage.VerifyItem(item_name);
		detailsPage.clickAddToCard();
		cardpage.VerifyItem(item_name);
	}
	
	@AfterSuite
	public void end_test() {
		close_browser();
	}
	
	
}
