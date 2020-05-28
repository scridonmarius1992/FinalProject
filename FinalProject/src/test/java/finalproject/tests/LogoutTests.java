package finalproject.tests;

import finalproject.base.BaseTest;
import finalproject.pages.WelcomePage;
import finalproject.util.LoginUtils;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogoutTests extends BaseTest {

    @Test
    public void logOut() throws IOException, ParseException {
        loginIntoApplication(LoginUtils.getLoginCredentials());
        getLoginPage().getLogOutButton().click();
        WelcomePage welcomePage = PageFactory.initElements(driver, WelcomePage.class);

        Assert.assertTrue(welcomePage.getLoginButton().isDisplayed());
    }
}
