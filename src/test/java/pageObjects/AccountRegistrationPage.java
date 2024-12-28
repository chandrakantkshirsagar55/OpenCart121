package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BaseObject {

    // Constructor
    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    // WebElements with @FindBy annotations
    @FindBy(xpath = "//input[@id='input-firstname']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='input-lastname']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='input-telephone']")
    private WebElement telephone;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='input-confirm']")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//label[normalize-space()='Yes']")
    private WebElement termsAndConditionsYes;

    // Methods to interact with WebElements
    public void setFirstName(String fname) {
        firstName.sendKeys(fname);
    }

    public void setLastName(String lname) {
        lastName.sendKeys(lname);
    }

    public void setEmail(String emailAddress) {
        email.sendKeys(emailAddress);
    }

    public void setTelephone(String phoneNumber) {
        telephone.sendKeys(phoneNumber);
    }

    public void setPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void setConfirmPassword(String confirmPwd) {
        confirmPassword.sendKeys(confirmPwd);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void acceptTermsAndConditions() {
        termsAndConditionsYes.click();
    }
}
