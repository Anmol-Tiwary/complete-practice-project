package anmolTiwary.EndToEnd_project;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.base;

public class vlidateNavigation extends base{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException 
	{
		driver = initializeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));	
	}
	
	@Test
	public <LndingPage> void basePageNavigation() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage l= new LandingPage(driver);
		Assert.assertTrue(l.Naviagtion().isDisplayed());
		log.info("test is validated");
	}
	@AfterTest
	public void CloseBrowser()
	{
		driver.close();
	}

}
