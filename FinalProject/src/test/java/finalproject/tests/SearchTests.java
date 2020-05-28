package finalproject.tests;

import finalproject.base.BaseTest;
import finalproject.pages.SearchProductsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.CollectionUtils;

import java.util.Collection;
import java.util.List;

public class SearchTests extends BaseTest {
    SearchProductsPage searchPage;

    @Test
    public void searchSpecificProductTest() {
        searchPage = PageFactory.initElements(driver, SearchProductsPage.class);
        searchPage.getSearchField().sendKeys("iphone");
        searchPage.getSearchBtn().click();

        List<WebElement> productsList = driver.findElements(By.className("listing-card"));
        Assert.assertTrue(CollectionUtils.hasElements(productsList));
    }

    @Test
    public void searchInvalidProduct() {
        searchPage = PageFactory.initElements(driver, SearchProductsPage.class);
        searchPage.getSearchField().sendKeys("dfsdg4t34sf");
        searchPage.getSearchBtn().click();
        Assert.assertTrue(searchPage.getMessageNoResult().getText().contains("There are no results matching"));
    }
}
