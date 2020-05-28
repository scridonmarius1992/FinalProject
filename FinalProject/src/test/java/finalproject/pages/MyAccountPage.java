package finalproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyAccountPage {

    @FindBy(how = How.XPATH, using = "//li[@class='first logged']/strong/a")
    public WebElement myaccount;
    @FindBy(how = How.XPATH, using = "//li[@class='opt_change_password']/a")
    public WebElement changePasswordBtn;
    @FindBy(how = How.ID, using = "password")
    public WebElement currentPassword;
    @FindBy(how = How.ID, using = "new_password")
    public WebElement newPassword;
    @FindBy(how = How.ID, using = "new_password2")
    public WebElement repeatnewPassword;
    @FindBy(how = How.ID, using = "flashmessage")
    public WebElement changePasswordMessage;
    @FindBy(how = How.XPATH, using = "//button[contains(@type,'submit')]")
    public WebElement updateBtn;
    @FindBy(how = How.ID, using = "s_username")
    public WebElement username;
    @FindBy(how = How.XPATH, using = "//li[@class='opt_change_username']")
    public WebElement changeUserName;
    @FindBy(how = How.ID, using = "flashmessage")
    public WebElement message;

    public WebElement getMyaccount() {
        return myaccount;
    }

    public void setMyaccount(WebElement myaccount) {
        this.myaccount = myaccount;
    }

    public WebElement getChangePasswordBtn() {
        return changePasswordBtn;
    }

    public void setChangePasswordBtn(WebElement changePasswordBtn) {
        this.changePasswordBtn = changePasswordBtn;
    }

    public WebElement getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(WebElement currentPassword) {
        this.currentPassword = currentPassword;
    }

    public WebElement getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(WebElement newPassword) {
        this.newPassword = newPassword;
    }

    public WebElement getRepeatnewPassword() {
        return repeatnewPassword;
    }

    public void setRepeatnewPassword(WebElement repeatnewPassword) {
        this.repeatnewPassword = repeatnewPassword;
    }

    public WebElement getChangePasswordMessage() {
        return changePasswordMessage;
    }

    public void setChangePasswordMessage(WebElement changePasswordMessage) {
        this.changePasswordMessage = changePasswordMessage;
    }

    public WebElement getUpdateBtn() {
        return updateBtn;
    }

    public void setUpdateBtn(WebElement updateBtn) {
        this.updateBtn = updateBtn;
    }

    public WebElement getUsername() {
        return username;
    }

    public void setUsername(WebElement username) {
        this.username = username;
    }

    public WebElement getChangeUserName() {
        return changeUserName;
    }

    public void setChangeUserName(WebElement changeUserName) {
        this.changeUserName = changeUserName;
    }

    public WebElement getMessage() {
        return message;
    }

    public void setMessage(WebElement message) {
        this.message = message;
    }

    public void changePassword(String currentPassword, String newPassword) {
        this.changePasswordBtn.click();
        this.currentPassword.sendKeys(currentPassword);
        this.newPassword.sendKeys(newPassword);
        this.repeatnewPassword.sendKeys(newPassword);
        this.updateBtn.click();
    }
}
