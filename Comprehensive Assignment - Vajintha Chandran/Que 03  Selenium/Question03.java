package Questions3and4;


import org.openqa.selenium.By;


public class Question03 extends Basic_utilities{
	
	// page elements
	public static By logo=By.xpath("//img[@class='coh-image coh-image-responsive-xl']"); //Relative XPath
	public static By button_RequestDemo = By.xpath("/html/body/div[1]/header/div/div/div/div[2]/div/div/div[1]/div[2]/a");  //Absolute XPath
	public static By button_accept_all_cookie = By.xpath("//*[@id='onetrust-accept-btn-handler']"); 
	
	
	public static void main(String[] args) {
		
		open_driver("chrome");
		navigate_to_URL("https://www.automationanywhere.com/");  
		click(button_accept_all_cookie);
		
		
		//-------------Question 03-a-------------
		verify_logo();
		
		
		//-------------Question 03-b-------------
		verify_RequestDemo_button();
		
		
		//verify_RequestDemo_button_navigation();
			
		
		close_browser();		
	}
	
	
	public static void verify_logo() {
		if(is_displayed(logo))
			System.out.println("Test Pass: logo present");
		else
			System.out.println("Test Failed: logo is not present");
	}
	
	
	public static void verify_RequestDemo_button() {
		
		if(is_displayed(button_RequestDemo))  
			System.out.println("Test Pass: RequestDemo button is present");
		else
			System.out.println("Test Failed: RequestDemo button is not present");
		
		
		System.out.println("Scroll down the page by 200px");
		scroll_browser(0,200);
		
		
		if(is_displayed(button_RequestDemo))  
			System.out.println("Test Pass: RequestDemo button is present");
		else
			System.out.println("Test Failed: RequestDemo button is not present");
		
		
		if(is_enabled(button_RequestDemo))  
			System.out.println("Test Pass: RequestDemo button is enabled");
		else
			System.out.println("Test Failed: RequestDemo button is not enabled");
	}
	
	
	public static void verify_RequestDemo_button_navigation() {
		click(button_RequestDemo);
		if(get_current_url().equals("https://www.automationanywhere.com/request-live-demo"))
				System.out.println("Test Pass: 'Request Demo' link navigated to correct page");
		else
			System.out.println("Test Pass: 'Request Demo'link navigated to wrong page");
	}
	

}
