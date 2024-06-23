package pageObjects;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	//constructor to call the driver from BasePage class
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
//	public HomePage(Webdriver driver) {
//		Super(driver);
//	}
	
//	@FindBy(xpath="//span[@id='name']")
//	WebElement lnk;

/*since we are creating a page factory constructor in BasePage class & are calling it here,
  we can use the below @FindBy to locate web elements & store then in a WebElement named as per
  our choice, like shown below in line 18 & 19*/
@FindBy(xpath="//span[normalize-space()='My Account']") 
WebElement lnkMyaccount;

@FindBy(xpath="//a[normalize-space()='Register']") 
WebElement lnkRegister;

@FindBy (xpath="//a[normalize-space()='Login']")
WebElement linkLogin;



public void clickMyAccount()
{
	lnkMyaccount.click();
}

public void clickRegister()
{
	lnkRegister.click();
}

public void clickLogin() {
	linkLogin.click();
}

}
