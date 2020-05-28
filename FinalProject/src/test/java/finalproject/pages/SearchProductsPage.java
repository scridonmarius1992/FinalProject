package finalproject.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SearchProductsPage {
    @FindBy(how = How.ID, using = "query")
    public WebElement searchField;
    @FindBy(how = How.XPATH, using = "//button[@class='ui-button ui-button-big js-submit']")
    public WebElement searchBtn;
    @FindBy(how = How.ID, using = "listing-card-list")
    public List<WebElement> listProduct;
    @FindBy(how = How.XPATH, using = "li.last-child")
    public WebElement searchResult;
    @FindBy(how = How.XPATH, using = "//p[@class='empty']")
    public WebElement messageNoResult;


    public WebElement getSearchField() {
        return searchField;
    }

    public void setSearchField(WebElement searchField) {
        this.searchField = searchField;
    }

    public WebElement getSearchBtn() {
        return searchBtn;
    }

    public List<WebElement> getListProduct() {
        return listProduct;
    }

    public WebElement getSearchResult() {
        return searchResult;
    }

    public WebElement getMessageNoResult() {
        return messageNoResult;
    }

    public void search(String iphone) throws Exception {

        searchField.clear();
        searchField.sendKeys(iphone);
        searchBtn.click();

    }
}
