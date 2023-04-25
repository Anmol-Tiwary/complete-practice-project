package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException
	{
		prop= new Properties();
		FileInputStream file= new FileInputStream("D:\\selenium training\\EndToEnd_project\\src\\main\\java\\resources\\data.properties");
		
		prop.load(file);
		String bName=prop.getProperty("browser");
		System.out.println(bName);
		
		
		//when we are importing value from a property we need to use'equals' not'==' sign
		if(bName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D://chromedriver//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (bName.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver","D:\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
		
	}
	
	public void getScreenshot(String failedTest, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		//currently it is stored in virtual sys. so to store it in local file below command is used
		//to bring failed tests from listeners.
		String DestFile= System.getProperty("use.dir")+"\\reports\\"+failedTest+".png";
		FileUtils.copyFile(source, new File(DestFile));
	}
	
	
}
