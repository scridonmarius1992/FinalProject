package finalproject.pages;
import finalproject.models.LoginAccountModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.ID, using = "email")
    public WebElement email;
    @FindBy(how = How.ID, using = "password")
    public WebElement password;
    @FindBy(how = How.XPATH, using = "//div[@class='controls']/button")
    public WebElement loginButton;
    @FindBy(how = How.XPATH,using = "//li[@class='first logged']/a")
    public WebElement logOutButton;
    @FindBy(how = How.ID, using = "flashmessage")
    public WebElement loginErrorMessage;

    public WebElement getEmail() {
        return email;
    }

    public void setEmail(WebElement email) {
        this.email = email;
    }

    public WebElement getPassword() {
        return password;
    }

    public void setPassword(WebElement password) {
        this.password = password;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(WebElement loginButton) {
        this.loginButton = loginButton;
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }

    public void setLogOutButton(WebElement logOutButton) {
        this.logOutButton = logOutButton;
    }

    public WebElement getLoginErrorMessage() {
        return loginErrorMessage;
    }

    public void setLoginErrorMessage(WebElement loginErrorMessage) {
        this.loginErrorMessage = loginErrorMessage;
    }

    public void login(LoginAccountModel loginAccountModel) {
        email.clear();
        email.sendKeys(loginAccountModel.getEmail());

        password.clear();
        password.sendKeys(loginAccountModel.getPassword());

        loginButton.click();
    }
}
