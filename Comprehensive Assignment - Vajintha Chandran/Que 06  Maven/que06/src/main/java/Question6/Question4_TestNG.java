package Question6;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;

public class Question4_TestNG extends Basic_utilities_TestNG {
	
	// page elements
	public  By button_accept_all_cookie = By.xpath("//*[@id='onetrust-accept-btn-handler']"); 
	public  By link_headerOption;
	
	
	@DataProvider(name="test_data")
	public String[][] header_link_data_provider(){
		
		String[][] headerLinks = {{"Products","https://www.automationanywhere.com/products"}, 
				  {"Solutions","https://www.automationanywhere.com/solutions"}, 
				  {"Resources","https://www.automationanywhere.com/resources"}, 
				  {"Beyond RPA","https://www.automationanywhere.com/rpa/robotic-process-automation"}, 
				  {"Company","https://www.automationanywhere.com/company/about-us"}};
		
		return headerLinks;
	}
	
	
	@Test (dataProvider ="test_data", timeOut = 1000)
	public void verify_home_header_link_availability(String link_name, String url ) {
		
		link_headerOption =By.xpath("//a[text()='"+link_name+"']");
		Assert.assertTrue(is_displayed(link_headerOption), "'"+link_headerOption+"' is not present");		
	}
	
	
	
	@Test (dependsOnMethods = { "verify_home_header_link_availability" }, dataProvider ="test_data", priority=1)
	public void verify_home_header_links_navigation(String link_name, String url ) {
		
		link_headerOption =By.xpath("//a[text()='"+link_name+"']");
		
		click(link_headerOption);
		
		Assert.assertEquals(get_current_url(), url,"'"+link_name+"' link navigated to wrong page");
		
		navigate_back();		
	}
	
	
	@BeforeClass
	public void set_up() {
		open_driver("chrome");
		navigate_to_URL("https://www.automationanywhere.com/");  
		click(button_accept_all_cookie);
	}
	  
	
	@AfterClass
	public void tear_down() {
		close_browser();
	}

}
