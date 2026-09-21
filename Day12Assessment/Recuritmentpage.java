package Day12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeRecuritmentPage {
	WebDriver driver;
	
	public OrangeRecuritmentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//a[text()='Vacancies']")
	private WebElement vacancies;
	
	@FindBy(xpath="//button[normalize-space()='Add']")
	private WebElement addButton;
	
	@FindBy(xpath="//label[normalize-space()='Vacancy Name']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	private WebElement vname;
	
	@FindBy(xpath="//label[text()='Job Title']/../..//div[contains(@class,'oxd-select-text oxd-select-text')]")
	private WebElement jobTitle;
	
	@FindBy(xpath="//label[text()='Description']/../..// textarea")
	private WebElement discription;
	
	@FindBy(xpath="//label[text()='Hiring Manager']/../..// input")
	private WebElement hiringManager;
	
	@FindBy(xpath="//label[text()='Number of Positions']/../..// input")
	private WebElement noOfPositions;
	
	@FindBy(xpath="//button[text()=' Save ']")
	private WebElement save;

	public void getVacancies() {
		vacancies.click();
	}

	public void getAddButton() {
		addButton.click();
	}

	public void getVname(String value) {
		vname.sendKeys(value);
	}

	public void getJobTitle(String value) {
		jobTitle.click();
	}

	public void getDiscription(String value) {
		 discription.sendKeys(value);;
	}

	public void getHiringManager(String value) {
		hiringManager.sendKeys(value);;
	}

	public void getNoOfPositions(String value) {
		noOfPositions.sendKeys(value);
	}

	public void getSave() {
		save.click();
	}
	
	
	
	

}
