package question5_Part1;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Question3_TestNG extends Basic_utilities_TestNG {
	
  // page elements
  public  By logo=By.xpath("//img[@class='coh-image coh-image-responsive-xl']"); //Relative XPath
  public  By button_RequestDemo = By.xpath("/html/body/div[1]/header/div/div/div/div[2]/div/div/div[1]/div[2]/a");  //Absolute XPath
  public  By button_accept_all_cookie = By.xpath("//*[@id='onetrust-accept-btn-handler']"); 
		
		
  
  @Test(priority=2)
  //-------------Question 03-b-------------
  public void verify_RequestDemo_button() {
	  
	SoftAssert soft_assert=new SoftAssert(); //Used soft assert-Without scrolling button is not visible
	
	soft_assert.assertTrue(is_displayed(button_RequestDemo), "RequestDemo button is not present");
		
	//Scroll down the page by 200px
	scroll_browser(0,200);
		
	soft_assert.assertTrue(is_displayed(button_RequestDemo), "RequestDemo button is not present");
	soft_assert.assertTrue(is_enabled(button_RequestDemo), "RequestDemo button is not enabled");
	
  }
  
  
  @Test(priority=1)
  //-------------Question 03-a-------------
  public void verify_logo() {
	Assert.assertTrue(is_displayed(logo), "logo is not present");
  }
  
  
  
  @Test(enabled=false)
  //-------------This is not available in the question-------------
  public void verify_RequestDemo_button_navigation() {
	click(button_RequestDemo);
	Assert.assertEquals(get_current_url(), "https://www.automationanywhere.com/request-live-demo","Request Demo'link navigated to wrong page");
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
