package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BaseObject{

	public MyAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath="//h2[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy (xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement LogoutButton;
	
	
	public boolean myAccountACCVerification() {
				
		if(myAccount.isDisplayed()) {
		System.out.println(myAccount.getText());
		return true;
		
		}
		else {
			return false;
		}
	}
	
	public void clickOnLogout() {
		LogoutButton.click();
	}
	

}
