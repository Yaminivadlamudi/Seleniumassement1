package orangeHRM;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Day12.OrangeBaseClass;
import Day12.OrangeHomePage;
import Day12.OrangeLogoutPage;
import Day12.OrangeMyInfoPage;
import Day12.OrangeRecuritmentPage;
import Day12.OrangeloginPage;

public class OrangeImplementation extends OrangeBaseClass {
	
	
	
	@Test(dataProvider="vacancyData")
	public void vacancyTest(String vacancyName,
            String jobTitle,
            String description,
            String hiringManager,
            String positions) throws InterruptedException {
		OrangeHomePage homePage=new OrangeHomePage(driver);
		OrangeRecuritmentPage recuritment=new OrangeRecuritmentPage(driver);
		
		     homePage.getRecuritment();
		     
             // Click Vacancies
		     
		     recuritment.getVacancies();
		     
             recuritment.getAddButton();
             // Click Add
             
           
              // Enter Vacancy Name
              recuritment.getVname(vacancyName);
              Thread.sleep(2000);             
              // Select Job Title
              recuritment.getJobTitle(jobTitle);
             
              // Enter Description
              recuritment.getDiscription(description);
            
              // Enter Hiring Manager
              recuritment.getHiringManager(hiringManager);
             
              // Enter Number of Positions
              recuritment.getNoOfPositions(positions);
              
             // Click Save
              recuritment.getSave();
             Thread.sleep(2000);
             // Validation
              
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Vacancy creation step completed");
              
              
		
		
		
	}
	
	@Test(dataProvider = "employeeData")
    public void editEmployeeDetailsTest(
            String firstName,
            String lastName,
            String employeeId)
            throws InterruptedException, IOException {
		OrangeHomePage homePage=new OrangeHomePage(driver);
		OrangeMyInfoPage  infoPage=new OrangeMyInfoPage(driver);

       


        // Click My Info
        homePage.getMyInf();


        // Change First Name
        infoPage.changeFirstName(firstName);


        // Change Last Name
        infoPage.changeLastName(lastName);


        // Change Employee ID
        infoPage.changeEmployeeId(employeeId);


        // Click Save
        infoPage.clickSave();
        OrangeLogoutPage logout=new OrangeLogoutPage(driver);
        logout.logout();

        // 7. Login again
        data();
        OrangeloginPage login = new OrangeloginPage(driver);

        driver.get(url);

        login.getUsernametf(username);
        login.getPasswordtf(password);
        login.getLoginButton();

        // 8. Go to My Info
        infoPage = new OrangeMyInfoPage(driver);
        infoPage.clickMyInfo();

        // 9. Verify First Name
        Assert.assertEquals(
                infoPage.getFirstName(),
                firstName,
                "First Name was not updated");

        // 10. Verify Last Name
        Assert.assertEquals(
                infoPage.getLastName(),
                lastName,
                "Last Name was not updated");

        // 11. Verify Employee ID
        Assert.assertEquals(
                infoPage.getEmployeeId(),
                employeeId,
                "Employee ID was not updated");

        System.out.println("Employee details updated and verified successfully");

        // 12. Logout
      
        logout.logout();
        
        


        
    }
	
	
	
	
	

}
