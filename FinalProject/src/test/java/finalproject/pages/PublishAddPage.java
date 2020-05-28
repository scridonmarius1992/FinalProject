package finalproject.pages;

import finalproject.models.AdModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class PublishAddPage {
    @FindBy(how = How.ID, using = "catId")
    public WebElement category;
    @FindBy(how = How.ID, using = "titleen_US")
    public WebElement title;
    @FindBy(how = How.ID, using = "descriptionen_US")
    public WebElement description;
    @FindBy(how = How.ID, using = "price")
    public WebElement price;
    @FindBy(how = How.ID, using = "currency")
    public WebElement currency;
    @FindBy(how = How.XPATH, using = "//div[@class='qq-upload-button']")
    public WebElement uploadImg;
    @FindBy(how = How.ID, using = "regionId")
    public WebElement region;
    @FindBy(how = How.ID, using = "cityId")
    public WebElement city;
    @FindBy(how = How.ID, using = "cityArea")
    public WebElement cityArea;
    @FindBy(how = How.ID, using = "address")
    public WebElement address;
    @FindBy(how = How.XPATH, using = "//div[@class='controls']/button[@type='submit']")
    public WebElement publishBtn;
    @FindBy(how = How.ID, using = "flashmessage")
    public WebElement publishMessage;

    public WebElement getCategory() {
        return category;
    }

    public void setCategory(WebElement category) {
        this.category = category;
    }

    public WebElement getTitle() {
        return title;
    }

    public void setTitle(WebElement title) {
        this.title = title;
    }

    public WebElement getDescription() {
        return description;
    }

    public void setDescription(WebElement description) {
        this.description = description;
    }

    public WebElement getPrice() {
        return price;
    }

    public void setPrice(WebElement price) {
        this.price = price;
    }

    public WebElement getCurrency() {
        return currency;
    }

    public void setCurrency(WebElement currency) {
        this.currency = currency;
    }

    public WebElement getRegion() {
        return region;
    }

    public void setRegion(WebElement region) {
        this.region = region;
    }

    public WebElement getCity() {
        return city;
    }

    public void setCity(WebElement city) {
        this.city = city;
    }

    public WebElement getCityArea() {
        return cityArea;
    }

    public void setCityArea(WebElement cityArea) {
        this.cityArea = cityArea;
    }

    public WebElement getAddress() {
        return address;
    }

    public void setAddress(WebElement address) {
        this.address = address;
    }

    public WebElement getPublishBtn() {
        return publishBtn;
    }

    public void setPublishBtn(WebElement publishBtn) {
        this.publishBtn = publishBtn;
    }

    public WebElement getUploadImg() {
        return uploadImg;
    }

    public void setUploadImg(WebElement uploadImg) {
        this.uploadImg = uploadImg;
    }

    public WebElement getPublishMessage() {
        return publishMessage;
    }

    public void setPublishMessage(WebElement publishMessage) {
        this.publishMessage = publishMessage;
    }

    public WebElement getPublishErrorMessage() {
        return publishMessage;
    }

    public void setPublishErrorMessage(WebElement publishErrorMessage) {
        this.publishMessage = publishErrorMessage;
    }



    public void add(AdModel adModel) {
        new Select(category).selectByVisibleText(adModel.getCategory());
        title.sendKeys(adModel.getTitle());
        description.sendKeys(adModel.getDescription());
        price.sendKeys(adModel.getPrice());
        new Select(region).selectByVisibleText(adModel.getRegion());
        new Select(city).selectByVisibleText(adModel.getCity());
        cityArea.sendKeys(adModel.getCityArea());
        address.sendKeys(adModel.getAddress());
        publishBtn.click();
    }
}
