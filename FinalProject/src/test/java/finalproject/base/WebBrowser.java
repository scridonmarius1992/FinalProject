package finalproject.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;


public class WebBrowser {
    public static WebDriver getDriver(String browser) {
        return getDriver(Browser.valueOf(browser.toUpperCase()));
    }

    public static WebDriver getDriver(Browser browser) {
        WebDriver driver;
        if (System.getenv("CI") != null) {
            System.out.println("Running tests on Gitlab pipeline");
            ChromeOptions options = new ChromeOptions().setHeadless(true);
            return new ChromeDriver(options);
        }
        switch (browser) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
//                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
//                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case IE:
                WebDriverManager.iedriver().setup();
//                System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            case OPERA:
                WebDriverManager.operadriver().setup();
                driver = new OperaDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser.toString());
        }
        return driver;
    }
}

