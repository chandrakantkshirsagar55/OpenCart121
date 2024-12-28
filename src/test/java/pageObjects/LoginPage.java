package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseObject{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath="//input[@id='input-email']")
	WebElement Username;
	
	@FindBy (xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy (xpath="//input[@value='Login']")
	WebElement LoginButton;

	public void setUssername(String username) {
		Username.sendKeys(username);
	}
	
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnLogin() {
		LoginButton.click();
	}
}
