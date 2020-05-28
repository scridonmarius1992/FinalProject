package finalproject.base;

import finalproject.models.LoginAccountModel;
import finalproject.models.LoginModel;
import finalproject.pages.LoginPage;
import finalproject.pages.WelcomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static String BASE_URL = "http://siit.atwebpages.com/osc/";
    private static final String LOGIN_PAGE_URL = BASE_URL + "index.php?page=login";

    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeMethod
    public void initDriver() {
        driver = WebBrowser.getDriver(Browser.CHROME);
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.close();
        }
    }

    protected File[] getListOfFilesFromResources(String directoryName) throws UnsupportedEncodingException {
        ClassLoader classLoader = getClass().getClassLoader();
        File directory = new File(URLDecoder.decode(classLoader.getResource(directoryName).getPath(), "UTF-8"));
        File[] files = directory.listFiles();
        System.out.println("Found " + files.length + " files in " + directoryName + " folder");
        return files;
    }

    protected File getFileFromResources(String fileName) throws UnsupportedEncodingException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(URLDecoder.decode(classLoader.getResource(fileName).getFile(), "UTF-8"));
        System.out.println(String.format("Found file %s", file.getName()));
        return file;
    }

    protected void login(LoginModel loginModel) {
        driver.get(BASE_URL + "index.php?page=login");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(loginModel.getAccount());

        if (loginModel.expectSuccessfulLogin()) {
            WelcomePage welcomePage = PageFactory.initElements(driver, WelcomePage.class);
            Assert.assertTrue(welcomePage.getLoggedInBar().isDisplayed(), "");
        } else {
            Assert.assertEquals(loginPage.getLoginErrorMessage().getText(), loginModel.getLoginErrorMessage());
        }
    }

    public void setElementText(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    protected void loginIntoApplication(LoginAccountModel loginAccountModel) {
        driver.get(LOGIN_PAGE_URL);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(loginAccountModel);
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public WebDriver getDriver() {
        return driver;
    }
}

