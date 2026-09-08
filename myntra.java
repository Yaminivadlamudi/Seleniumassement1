package assessments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1navigatemyntra {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://www.myntra.com/");
	    driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("watches");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Watches For Women']")).click();

		Thread.sleep(3000);

		
		driver.findElement(By.xpath("(//span[text()='wishlist'])[1]")).click();
		

		Thread.sleep(2000);

	

	}

}