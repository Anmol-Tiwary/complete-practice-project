

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Count_validate_links {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "D:\\msedgedriver.exe");
		WebDriver d = new EdgeDriver();
		d.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(d.findElements(By.tagName("a")).size());
		WebElement footer = d.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		WebElement column = footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(column.findElements(By.tagName("a")).size());
		
		for(int i=1;i< column.findElements(By.tagName("a")).size(); i++)
		{
			String Clicklink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			column.findElements(By.tagName("a")).get(i).sendKeys(Clicklink);
			Thread.sleep(2000L);
		
		//open all the tabs
		Set<String> abc = d.getWindowHandles();
		Iterator<String> it = abc.iterator();
		
		while(it.hasNext())
		{
			d.switchTo().window(it.next());
			System.out.println(d.getTitle());
		} }
	}

	}

