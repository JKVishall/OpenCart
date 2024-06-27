package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Logger logger; //Log4j
	public Properties p;
	
	@BeforeClass(groups = {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setup(String os, String browser) throws Exception
	//public void setup() throws Exception
	{
		System.out.println("pass"+os+browser);
		FileReader file =new FileReader("src/test/resources//config.properties");
		//FileReader file =new FileReader("C://Users//vishjk//Test workspace//OpenCart//src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		
		logger = LogManager.getLogger(this.getClass()); 
		
		switch(browser.toLowerCase()) {
		case "chrome": driver = new ChromeDriver();
		break;
		case "edge"  : driver = new EdgeDriver();
		break;
		case "firefox":driver = new FirefoxDriver();
		break;
		default: System.out.println("Invalid browser name");
		return;
		}
		//driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(p.getProperty("url")); //reading browser url from config.properties file
		driver.manage().window().maximize();
		
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	public void tearDown()
	{
		driver.close();
	}
	

//	public String randomeString()
//	{
//		String generatedString=RandomStringUtils.randomAlphabetic(5);
//		return generatedString;
//	}
//	
//	public String randomeNumber()
//	{
//		String generatedString=RandomStringUtils.randomNumeric(10);
//		return generatedString;
//	}
//	
//	public String randomAlphaNumeric()
//	{
//		String str=RandomStringUtils.randomAlphabetic(3);
//		String num=RandomStringUtils.randomNumeric(3);
//		
//		return (str+"@"+num);
//	}
}
