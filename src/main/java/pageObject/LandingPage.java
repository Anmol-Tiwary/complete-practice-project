package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public  WebDriver driver;
	
	By signin= By.cssSelector("a[href*='sign_in']");
	By title = By.cssSelector("[class='pull-left']");
	By navBar= By.cssSelector("[class='auto-container clearfix']");
	
	//constructor
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement login()
	{
		return driver.findElement(signin);
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement Naviagtion()
	{
		return driver.findElement(navBar);
	}
}
