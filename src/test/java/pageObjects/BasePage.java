package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;
	
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		//PageFactory is used to use @FindBy and actions in a class directly
		//This is a constructor which will be directly called in other classes when using @FindBy
		
    }
	
//	Webdriver driver;
//	
//	public void BasePage(Webdriver driver) {
//		this.driver=driver;
//		PageFactory.initElements(driver, this);
//	}
	
	

//	Webdriver driver;
//	
//	//PageFactory
//	public BasePage(Webdriver driver) {
//		this.driver=driver;
//		PageFactory.initElements(driver,this);
//	}
//	
	
}
