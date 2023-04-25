package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	WebDriver driver;
	
	public loginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By login =By.name("email");
	By pass =By.id("password");
	By submit=By.name("commit");
	
	public WebElement email()
	{
		return driver.findElement(login);

	}
	public WebElement password()
	{
		return driver.findElement(pass);
	}
	public WebElement submit()
	{
		return driver.findElement(submit);
	}
}
