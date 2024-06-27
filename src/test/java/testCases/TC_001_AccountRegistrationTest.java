package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups="Sanity")
	public void verify_account_registration() throws Exception
	{
		try {
	    logger.info("Test begin");
		HomePage hp=new HomePage(driver);//object of HomePage class
		hp.clickMyAccount();
		logger.info("\"Clicked on My account\"");
		hp.clickRegister();
		logger.info("Click on register button");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);//object of AccountRegistrationPage class
		
		
		logger.info("Providing user info");
		regpage.setFirstName("John");
		regpage.setLastName("Cena");
		regpage.setEmail("johncessssnasrssrsslossstles"+"@gmail.com");// randomly generated the email
		regpage.setTelephone("112");
		
		
		String password="Password123123123";
//		regpage.setFirstName(randomeString().toUpperCase());
//		regpage.setLastName(randomeString().toUpperCase());
//		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
//		regpage.setTelephone(randomeNumber());
//		
//		String password=randomAlphaNumeric();
		
		
		logger.info("setting a password");
		regpage.setPassword(password);
		logger.info("setting of a password is done");
		regpage.setConfirmPassword(password);
		logger.info("confirming of a password is done");
		
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		Thread.sleep(4000);
		
		String confmsg=regpage.getConfirmationMsg();
		logger.info("Validating expected msg");
		logger.debug("Debug logs");
		logger.info("The Message is : " + confmsg);
		if (confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		} else {
			logger.info("I'm here");
			logger.error("Test failed" );
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg, "Your Account Has sBeen Created!");
		
		
		System.out.println(confmsg);
		logger.info("Test finishied");
		}
		catch(Exception e) {
			Assert.fail();
		}
		
	}
	
}








