package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BaseObject {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id='top-links']/ul/li[2]")
	WebElement lnkMyAccount;
	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement Resistor;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement Login;
	
	
	
	public void clickMyAccount() {
		System.out.println("In the clickMyAccount method");
		lnkMyAccount.click();
	}
	
	
	public void clickResistor() {
		Resistor.click();
	}

	public void clickLogin() {
		Login.click();
	}
	

}
