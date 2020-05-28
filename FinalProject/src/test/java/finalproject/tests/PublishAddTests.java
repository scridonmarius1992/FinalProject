package finalproject.tests;

import finalproject.base.BaseTest;
import finalproject.models.AdModel;
import finalproject.pages.PublishAddPage;
import finalproject.util.LoginUtils;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PublishAddTests extends BaseTest {

    @DataProvider(name = "publishDataProvider")
    public Iterator<Object[]> publishDataProvider() {
        Collection<Object[]> dataProvider = new ArrayList<>();

        dataProvider.add(new String[]{"  Cell Phones - Accessories", "Iphone", "11pro,256gb", "1000", "Euro €", "Cluj",
                "Cluj-Napoca", "dorobanti", "Porumbeilor 31", "x\nYour listing has been published"});
        dataProvider.add(new String[]{"  Cell Phones - Accessories", "Iphone", "", "1000", "Euro €", "Cluj",
                "Cluj-Napoca", "dorobanti", "Porumbeilor 31", "x\nDescription too short (en_US)."});
        dataProvider.add(new String[]{"  Cell Phones - Accessories", "", "11pro,256gb.....", "1000", "Euro €", "Cluj",
                "Cluj-Napoca", "dorobanti", "Porumbeilor 31", "x\nTitle too short (en_US)."});
        dataProvider.add(new String[]{"", "Iphone", "11pro,256gb.....", "1000", "Euro €", "Cluj",
                "Cluj-Napoca", "dorobanti", "Porumbeilor 31", "x\nChoose one category."});
        dataProvider.add(new String[]{"", "Iphone", "11pro,256gb.....", "", "", "",
                "", "", "", "x\nYour listing has been published"});
        return dataProvider.iterator();
    }

    @Test(dataProvider = "publishDataProvider")
    public void addPublishTest(String category, String title, String description, String price, String currency,
                               String region, String city,
                               String cityArea, String address, String publishMessage) throws IOException, ParseException {
        loginIntoApplication(LoginUtils.getLoginCredentials());
        driver.findElement(By.xpath("//li[@class='publish']")).click();
        PublishAddPage publishAddPage = PageFactory.initElements(driver, PublishAddPage.class);

        AdModel adModel = new AdModel(category, title, description, price, currency, region, city, cityArea, address);
        publishAddPage.add(adModel);

        Assert.assertEquals(publishMessage, publishAddPage.getPublishErrorMessage().getText());
    }
}
