package Day12;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class OrangeBaseClass extends OrangeCommonData{
	public WebDriver driver=null;
	
	@BeforeClass
	public void bC() throws IOException {
		data();

		if(browser.equalsIgnoreCase("chrome")) {
			
			ChromeOptions settings = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			
			driver=new ChromeDriver(settings);
		}
		if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		if(browser.equalsIgnoreCase("safari")) {
			driver=new SafariDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	
	@BeforeMethod
	public void bM() {
		OrangeloginPage login=new OrangeloginPage(driver);
		driver.get(url);
	     login.getUsernametf(username);
	     login.getPasswordtf(password);
	     login.getLoginButton();
	     
	     Reporter.log("Login Done",true);
		
		
	}
	
	@AfterMethod
	public void aM() {
		System.out.println("Logout Done");
		
	}
	
	@AfterClass
	public void aC() {
		driver.quit();
		System.out.println("Close Browser");
	}

}
