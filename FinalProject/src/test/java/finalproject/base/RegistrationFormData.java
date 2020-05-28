package finalproject.base;
import finalproject.pages.RegistrationPage;
import finalproject.pages.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class RegistrationFormData {

    ValueGenerator valueGenerator = new ValueGenerator();
    RegistrationPage registrationPage;
    WelcomePage welcomePage;

    public enum FormFields {NAME, EMAIL, PASSWORD, REPEATPASSWORD}

    public String Name;
    public String email;
    public String password;
    public String repeatpassword;


    public void setupTestData(FormFields field, String newData) {
        Name = field == FormFields.NAME ? newData : valueGenerator.generateAlphabetic(8);
        email = field == FormFields.EMAIL ? newData : valueGenerator.generate(7) + "@gmail.com";
        password = field == FormFields.PASSWORD ? newData : "aq12AQ!@";
        repeatpassword = field == FormFields.REPEATPASSWORD ? newData : "aq12AQ!@";
    }

    public void completeRegistrationForm(WebDriver driver) {
        registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
        registrationPage.completeRegistrationForm(Name, email, password, repeatpassword);
        welcomePage = PageFactory.initElements(driver, WelcomePage.class);
        Assert.assertEquals(welcomePage.getWelcomePageMessage(),"x\nYour account has been created successfully");

    }
}
