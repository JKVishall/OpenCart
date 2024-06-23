package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import jdk.internal.org.jline.utils.Log;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test
	public void verify_login() {
		try {
		logger.info("Starting the login");
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		MyAccountPage mp=new MyAccountPage(driver);
        boolean targetPage=mp.isMyAccountPageExists();
		
		Assert.assertEquals(targetPage, true,"Login failed");
		System.out.println("");
		}
		catch(Exception e)
		{
	        logger.error("case 2 failed");
	        logger.info("case 2 failed");
			Assert.fail();
		}
		
		logger.info("**** Finished TC_002_LoginTest  ****");

	}
	

}
