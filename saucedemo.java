package sample1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class launchbrowser  {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		Thread.sleep(2000);
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(2000);
		driver.findElement(By.id("login-button")).click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollTo(0, 1000);");
          TakesScreenshot tks = (TakesScreenshot)driver;
 		File src = tks.getScreenshotAs(OutputType.FILE);
 	    File dest = new File(".//Ss/saucedemo.png");
 		FileHandler.copy(src, dest);
 		Thread.sleep(2000);


         
	}

}
