package finalproject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WelcomePage {

    @FindBy(how = How.ID, using = "flashmessage")
    private WebElement welcomePageMessage;

    @FindBy(how = How.ID, using = "login_open")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//li[@class='first logged']")
    private WebElement loggedInBar;

    public String getWelcomePageMessage() {
        return welcomePageMessage.getText();
    }

    public WebElement getLoggedInBar() {
        return loggedInBar;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }
}
