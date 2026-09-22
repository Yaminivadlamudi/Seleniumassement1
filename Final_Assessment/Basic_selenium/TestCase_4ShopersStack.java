package FinalAssessment;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class shopersstack {

    public static void main(String[] args) {
WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.get("https://www.shoppersstack.com/");
		driver.findElement(By.xpath("//div[contains(@class,'MuiPape')]")).click();
		driver.findElement(By.id("Check Delivery")).sendKeys("583104");
		
		WebElement ref = driver.findElement(By.id("Check"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	    wait.until(ExpectedConditions.elementToBeClickable(ref));
	    ref.click();
			
		String text = driver.findElement(By.xpath("//p[text()='Not Deliveriable.']")).getText();
		System.out.println(text);
		driver.quit();
		
    }
}
