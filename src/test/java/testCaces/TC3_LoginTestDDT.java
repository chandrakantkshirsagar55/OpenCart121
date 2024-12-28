package testCaces;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LoginPage;
import pageObjects.MyAccount;
import utilities.DataProviders;

public class TC3_LoginTestDDT extends BaseClass {

	@Test(dataProvider = "loginData", dataProviderClass = DataProviders.class)
	public void loginTestDD(String username, String passwprd, String validation) {

		logger.info("**** starting Testcase3*****");

		System.out.println("username is ::"+username);
		homePage.clickMyAccount();
		homePage.clickLogin();

		LoginPage lp = new LoginPage(driver);
		lp.setUssername(username);
		lp.setPassword(passwprd);
		lp.clickOnLogin();

		MyAccount macc = new MyAccount(driver);

		boolean acc = macc.myAccountACCVerification();
		//Assert.assertTrue(acc);
		
		if (validation.equalsIgnoreCase("Valid")) {
			
			if(acc) {
				macc.clickOnLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
			
		}else {

			if(acc) {
				macc.clickOnLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}

		logger.info("**** end Testcase3*****");
		
		

	}

}
