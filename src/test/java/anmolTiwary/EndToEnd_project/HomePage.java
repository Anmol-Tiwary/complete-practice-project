package anmolTiwary.EndToEnd_project;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.loginPage;
import resources.base;

public class HomePage extends base {
	public WebDriver driver;
	
	public static Logger log =LogManager.getLogger(base.class.getName());
//using extends	keyword we are inheriting all the methods of any class here base class
	@BeforeTest
	public void initialize() throws IOException 
	{
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		log.info("navigated to home page");
	}
	
	@Test(dataProvider="getData")
	public void PageNavigation(String Username, String Password, String text) throws IOException, InterruptedException
	{
	
	//System.out.println("homePage is loading");
		driver.get(prop.getProperty("url"));
	//inheriting methods of other class
	LandingPage lp= new LandingPage(driver);
	lp.login().click();
	
	//Thread.sleep(4000);
	
	loginPage log= new loginPage(driver);
	log.email().sendKeys(Username);
	log.password().sendKeys(Password);
	System.out.println(text);
	log.submit().click();
	
	}

	@DataProvider
	public Object[][] getData()
	{
		//row stands for how many different data and 
		//column for how many values each test
		Object[][] data =new Object[2][3];
		data[0][0]="nonrestrictedusers@qw.com";
		data[0][1]="pass12345";
		data[0][2]="non restricted user";
		
		data[1][0]="resteicted@qw.com";
		data[1][1]="587698";
		data[1][2]="restricted user";
		
		return data;
	}
	
	@AfterTest
	public void CloseBrowser()
	{
		driver.close();
	}
}
