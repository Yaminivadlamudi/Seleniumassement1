package Pomutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHRMHomePage {

    WebDriver driver;

    public OrangeHRMHomePage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    // Recruitment

    @FindBy(xpath = "//span[normalize-space()='Recruitment']")
    private WebElement recruitment;


    // User dropdown

    @FindBy(xpath = "//span[contains(@class,'oxd-userdropdown-tab')]")
    private WebElement userDropdown;


    // Logout

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logout;


    // Click Recruitment

    public void getRecruitment() {

        recruitment.click();
    }


    // Click User Dropdown

    public void getUserDropdown() {

        userDropdown.click();
    }


    // Click Logout

    public void getLogout() {

        logout.click();
    }

}
