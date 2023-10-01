package Questions3and4;

import org.openqa.selenium.By;

public class Question04 extends Basic_utilities {
	
	// page elements
	public static By button_accept_all_cookie = By.xpath("//*[@id='onetrust-accept-btn-handler']"); 
	public static By link_headerOption;
	
	
	public static void main(String[] args) {
		
		open_driver("chrome");
		navigate_to_URL("https://www.automationanywhere.com/");  
		click(button_accept_all_cookie);
		
		
		String[][] headerLinks = {{"Products","https://www.automationanywhere.com/products"}, 
								  {"Solutions","https://www.automationanywhere.com/solutions"}, 
								  {"Resources","https://www.automationanywhere.com/resources"}, 
								  {"Beyond RPA","https://www.automationanywhere.com/rpa/robotic-process-automation"}, 
								  {"Company","https://www.automationanywhere.com/company/about-us"}};
		
		
		//Page URL Validation
		verify_home_header_links(headerLinks);
		
									
		close_browser();		
		
	}
	
	
	public static void verify_home_header_links(String [][]headerLinks ) {
		
		for(int i=0;i<headerLinks.length;i++) {
			
			link_headerOption =By.xpath("//a[text()='"+headerLinks[i][0]+"']");
			
			if(is_displayed(link_headerOption)) {
				
				System.out.println("Test Pass: '"+headerLinks[i][0]+"' link is present");
				
				click(link_headerOption);
				
				if(get_current_url().equals(headerLinks[i][1]))
					System.out.println("Test Pass: '"+headerLinks[i][0]+"' link navigated to correct page");
				else
					System.out.println("Test Pass: '"+headerLinks[i][0]+"'link navigated to wrong page");
				
				navigate_back();
			}
			else
				System.out.println("Test Pass: '"+headerLinks[i][0]+"' link is not present");
		}
	}
	
	
}