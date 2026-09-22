package FinalAssessment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoqspiders1 {

    public static void main(String[] args) {

        WebDriver driver1 = new ChromeDriver();

        driver1.manage().window().maximize();

        driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver1.get("https://demoapps.qspiders.com/ui/toggle?sublist=0");

       
     List<WebElement> reff = driver1.findElements(By.xpath( "//span[contains(@class,'absolute left-[3px] top-[2px] translate-x-0 inline-block w-3 h-3 transition duration-300')]"  ));
      JavascriptExecutor js = (JavascriptExecutor) driver1;
          for (WebElement ref : reff) {
        	 js.executeScript( "arguments[0].removeAttribute('disabled');", ref);
       ref.click();
        }
          driver1.findElement(By.id("togglers")).click();

       
        WebElement text = driver1.findElement(
                By.xpath("//p[@class='text-lg text-orange-600 font-bold text-center']"));
           if (text.getText().equals("ORDER PLACED")) {

            System.out.println("yes it is placed");

        } else {

            System.out.println("no order is not placed");
        }

        driver1.quit();
    }
}
