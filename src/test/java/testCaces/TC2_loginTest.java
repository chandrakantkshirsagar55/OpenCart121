package testCaces;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LoginPage;
import pageObjects.MyAccount;

public class TC2_loginTest extends BaseClass{
	
	@Test (groups="Sanity")
	public void Login() {
		logger.info("**** starting Testcase2*****");
	    
	    homePage.clickMyAccount();
	    homePage.clickLogin();
	    
	    LoginPage lp=new LoginPage(driver);
	    lp.setUssername(p.getProperty("email"));
	    lp.setPassword(p.getProperty("password"));
	    lp.clickOnLogin();
	    
	    MyAccount macc=new MyAccount(driver);
	    
	    boolean acc=macc.myAccountACCVerification();
	    Assert.assertTrue(acc);
	    
	    logger.info("**** end Testcase2*****");
	    
	}
	

}
