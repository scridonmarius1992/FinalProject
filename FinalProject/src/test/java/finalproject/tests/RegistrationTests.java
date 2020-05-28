package finalproject.tests;

import finalproject.base.BaseTest;
import finalproject.base.RegistrationFormData;
import finalproject.base.ValueGenerator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class RegistrationTests extends BaseTest {
    private ValueGenerator valueGenerator;

    @Test
    public void registrationTest() {
        valueGenerator = PageFactory.initElements(driver, ValueGenerator.class);
        driver.get(BASE_URL + "index.php?page=register&action=register");

        RegistrationFormData registrationFormData = new RegistrationFormData();
        registrationFormData.setupTestData(RegistrationFormData.FormFields.NAME, valueGenerator.generateAlphabetic(8));
        registrationFormData.completeRegistrationForm(driver);
    }
}
