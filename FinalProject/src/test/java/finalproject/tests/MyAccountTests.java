package finalproject.tests;

import finalproject.base.BaseTest;
import finalproject.models.LoginAccountModel;
import finalproject.pages.LoginPage;
import finalproject.pages.MyAccountPage;
import finalproject.util.LoginUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class MyAccountTests extends BaseTest {

    @Test
    public void changeUserNameFailedTest() throws IOException, ParseException {
        driver.findElement(By.id("login_open")).click();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        final LoginAccountModel loginAccountModel = LoginUtils.getLoginCredentials();
        loginPage.login(loginAccountModel);

        driver.findElement(By.xpath("//li[@class='first logged']/strong/a")).click();
        MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);

        myAccountPage.getChangeUserName().click();
        myAccountPage.getUsername().sendKeys("marius");
        myAccountPage.getUpdateBtn().click();

        Assert.assertTrue(myAccountPage.getMessage().getText().contains("The specified username is already in use"));
    }

    @Test
    public void changePasswordTest() throws IOException, ParseException {
        final LoginAccountModel loginAccountModel = LoginUtils.getLoginCredentials();
        loginIntoApplication(loginAccountModel);

        driver.findElement(By.xpath("//li[@class='first logged']/strong/a")).click();
        MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);

        final String currentPassword = loginAccountModel.getPassword();
        final String newPassword = RandomStringUtils.random(15, true, true);
        myAccountPage.changePassword(currentPassword, newPassword);

        loginAccountModel.setPassword(newPassword);
        LoginUtils.changeLoginCredentials(loginAccountModel);

        Assert.assertTrue(myAccountPage.getChangePasswordMessage().getText().contains("Password has been changed"));
    }
}