//Test- case  1 
1.Navigate to DemoWebshop application 
2.Click on login link .
3.Enter email and password and click on login button by reading the data from property file.

//Data stored in Properties file

browser chrome
url   https://demowebshop.tricentis.com
email  yam123@gmail.com
password Yam@56


package demowebshopapplication;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webshop {

	public static void main(String[] args) throws IOException {
	FileInputStream file = new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\Day_Assesment5\\src\\main\\resources\\Dayassessment5.properties");
        Properties p = new Properties();
        p.load(file);
		String Browser = p.getProperty("browser");
		String Url = p.getProperty("url");
		String Email = p.getProperty("email");
		String Password = p.getProperty("password");
		WebDriver driver = null;
		if(Browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		if(Browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		if(Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(Url);
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		driver.findElement(By.id("Email")).sendKeys(Email);
		driver.findElement(By.id("Password")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		
		}

}


//Testcase 2 

1.Navigate to orange Hrm application
2.Enter the username password and click on login buuton
by redaing the data from excel file.

//Data is stored in Excel file


package demowebshopapplication;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class orangehrmapplication {
     public static void main(String[] args) throws EncryptedDocumentException, IOException {
			FileInputStream fl=new FileInputStream("./src/test/resources/maven/excelsample.xlxs.xlsx");
			Workbook w= WorkbookFactory.create(fl);
		    Sheet sh = w.getSheet("Sheet1");
			Row row = sh.getRow(1);
			 Cell cell = row.getCell(2);
		      System.out.println(cell.getStringCellValue());
			String browser = sh.getRow(1).getCell(0).getStringCellValue();
			String url = sh.getRow(1).getCell(1).getStringCellValue();
			String username = sh.getRow(1).getCell(2).getStringCellValue();
			String password = sh.getRow(1).getCell(3).getStringCellValue();
			WebDriver driver=null;
		 if(browser.equals("chrome")) {
			driver=new ChromeDriver();
						 }
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get(url);
	    driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
	    driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();

			}

		}

//Testcase 3 

1.Navigate to Demoappsqspiders application
2.Enter name, email,password and click on login  submit button
3.Read the data from json file.


//Data is stored in json file 

{
  "browser": "chrome",
  "Url": "https://demoapps.qspiders.com/ui?scenario=1",
  "Name": "yamini",
  "Email": "Yamini12@gmail.com",
  "Password": "yam@123"
}

package demowebshopapplication;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class demoqspiders {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {

		FileReader file = new FileReader("C:\\Users\\HP\\eclipse-workspace\\Day_Assesment5\\src\\main\\resources\\day5.json");
       JSONParser jsonparser = new JSONParser();
       Object obj = jsonparser.parse(file);
       JSONObject json = (JSONObject) obj;
        String Url = json.get("Url").toString();
		String Name = json.get("Name").toString();
        String Email = json.get("Email").toString();
        String Password = json.get("Password").toString();
         WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));driver.get(Url);
         driver.findElement(By.id("name")).sendKeys(Name);
	driver.findElement(By.id("email")).sendKeys(Email);
        driver.findElement(By.id("password")).sendKeys(Password);
       Thread.sleep(2000);
       driver.findElement(By.xpath("//button[@type='submit']")).click();
       Thread.sleep(2000);

		driver.quit();
	}
}




