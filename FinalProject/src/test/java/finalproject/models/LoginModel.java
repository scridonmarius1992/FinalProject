package finalproject.models;

public class LoginModel {
    private LoginAccountModel account;
    private String loginErrorMessage;

    public String getLoginErrorMessage() {
        return loginErrorMessage;
    }

    public void setLoginErrorMessage(String loginErrorMessage) {
        this.loginErrorMessage = loginErrorMessage;
    }

    public LoginAccountModel getAccount() {
        return account;
    }

    public void setAccount(LoginAccountModel account) {

        this.account = account;
    }


    public String toString() {
        return String.format("%s, %s", this.account, expectSuccessfulLogin());
    }

    public boolean expectSuccessfulLogin() {
        return "".equals(loginErrorMessage);
    }
}
