import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;


public class Calender_Handeling {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "D:\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://phptravels.net/");
        driver.manage().window().maximize();

        // Click on the date field
        driver.findElement(By.cssSelector("#checkin")).click();
        
        Thread.sleep(2000);
       
        while(!driver.findElement(By.xpath("/html/body/div[9]/div[1]/table/thead/tr[1]/th[2]"))
        		.getText().contains("June 2023"))
        {
        	driver.findElement(By.xpath("//body[1]/div[8]/div[1]/table[1]/thead[1]/tr[1]/th[3]/i[1]")).click();
        }
          
        List<WebElement> day =  driver.findElements(By.xpath("/html[1]/body[1]/div[8]/div[1]/table[1]/tbody[1]/tr/td"));
       int count = day.size();
       System.out.println(count);
       for (int i=0; i<count; i++)
       {
    	   String date = day.get(i).getText();
    	   
    	   if(date.equalsIgnoreCase("26")) {
    		    day.get(i).click();
    		    System.out.println("Date selected: " + date);
    		    break;
    		}

       }
       
       driver.quit();
    }
}
