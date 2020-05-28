package finalproject.pages;

import finalproject.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegistrationPage {

    @FindBy(how = How.ID, using = "s_name")
    private WebElement NameField;
    @FindBy(how = How.ID, using = "s_email")
    public WebElement emailField;
    @FindBy(how = How.ID, using = "s_password")
    public WebElement passwordField;
    @FindBy(how = How.ID, using = "s_password2")
    public WebElement repeatPasswordField;
    @FindBy(how = How.XPATH, using = "//button[contains(@type,'submit')]")
    public WebElement createButton;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Name')]")
    public WebElement NameErrorMessage;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'E-Mail')]")
    public WebElement emailError;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Password')]")
    public WebElement passwordError;
    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Repeat password')]")
    public WebElement repeatPasswordError;

    BaseTest baseTest = new BaseTest();

    public void setName(String Name) {
        baseTest.setElementText(NameField, Name);
    }

    public void setEmail(String email) {
        baseTest.setElementText(emailField, email);
    }

    public void setPassword(String password) {
        baseTest.setElementText(passwordField, password);
    }

    public void setrepeatPassword(String repeatPassword) {

        baseTest.setElementText(repeatPasswordField, repeatPassword);
    }

    public void clickCreateButton() {
        baseTest.clickElement(createButton);
    }

    public void setNameErrorMessage(WebElement NameErrorMessage) {
        this.NameErrorMessage = NameErrorMessage;
    }

    public WebElement getEmailError() {
        return emailError;
    }

    public void setEmailError(WebElement emailError) {
        this.emailError = emailError;
    }

    public WebElement getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(WebElement passwordError) {
        this.passwordError = passwordError;
    }

    public void setRepeatPasswordError(WebElement repeatPasswordError) {
        this.repeatPasswordError = repeatPasswordError;
    }

    public void completeRegistrationForm(String Name, String email, String password, String repeatPassword) {

        setName(Name);
        setEmail(email);
        setPassword(password);
        setrepeatPassword(repeatPassword);
        clickCreateButton();

    }
}
