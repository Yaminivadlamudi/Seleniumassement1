package Day12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHomePage {
	WebDriver driver;
	
	public OrangeHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//span[text()='Recruitment']")
	private WebElement recuritment;
	
	
	
	

	@FindBy(xpath="//span[text()='My Info']")
	private WebElement myInf;
	
	public void getRecuritment() {
		recuritment.click();
	}

	public void getMyInf() {
		myInf.click();
	}
	
	

}
