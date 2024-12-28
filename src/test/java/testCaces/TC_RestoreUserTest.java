package testCaces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_RestoreUserTest extends BaseClass {

   

    @Test
    public void testUserRegistration() {
    	
    	logger.info("**** starting Testcase*****");
        // Navigate to My Account > Register
        homePage.clickMyAccount();
        homePage.clickResistor();
        logger.info("clicked on resister");
        // Fill out the registration form
        registrationPage.setFirstName("John");
        registrationPage.setLastName("Doe");
        registrationPage.setEmail("john.doe@example1.com");
        registrationPage.setTelephone("1234567890");
        registrationPage.setPassword("password123");
        registrationPage.setConfirmPassword("password123");
        registrationPage.acceptTermsAndConditions();
        registrationPage.clickContinue();
        logger.info("done with the testCase");
        // Assert success (Assume a success message or redirect is expected)
        // Add assertions here based on the expected behavior
        System.out.println("User registration test executed successfully.");
    }

    
}
