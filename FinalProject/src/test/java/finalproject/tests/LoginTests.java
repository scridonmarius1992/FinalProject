package finalproject.tests;

import finalproject.base.BaseTest;
import finalproject.models.LoginAccountModel;
import finalproject.models.LoginModel;
import finalproject.util.LoginUtils;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class LoginTests extends BaseTest {

    @DataProvider(name = "loginDataProvider")
    public Iterator<Object[]> loginDataProvider() throws IOException, ParseException {
        Collection<Object[]> dataProvider = new ArrayList<>();

        final LoginAccountModel loginAccountModel = LoginUtils.getLoginCredentials();
        final String username = loginAccountModel.getEmail();
        final String password = loginAccountModel.getPassword();

        dataProvider.add(new String[]{username, password, ""});
        dataProvider.add(new String[]{username, password + "1", "x\nThe password is incorrect"});
        dataProvider.add(new String[]{"", "aq12AQ!@", "x\nPlease provide an email address"});
        dataProvider.add(new String[]{username, "", "x\nEmpty passwords are not allowed. Please provide a password"});
        dataProvider.add(new String[]{"", "", "x\nPlease provide an email address"});

        return dataProvider.iterator();
    }

    @Test(dataProvider = "loginDataProvider")
    public void loginTest(String email, String password, String loginErrorMessage) {
        LoginModel loginModel = new LoginModel();
        LoginAccountModel loginAccountModel = new LoginAccountModel();

        loginAccountModel.setEmail(email);
        loginAccountModel.setPassword(password);
        loginModel.setAccount(loginAccountModel);
        loginModel.setLoginErrorMessage(loginErrorMessage);

        login(loginModel);
    }
}
