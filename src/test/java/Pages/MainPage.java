package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainPage {
    AndroidDriver driver;
    WebDriverWait wait;
    Logger logger ;
    public MainPage(AndroidDriver driver){
        this.driver = driver;
        logger = LogManager.getLogger(MainPage.class);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/locationView")
    WebElement location;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/citySelectorView")
    WebElement citySelector;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/townSelectorView")
    WebElement townSelector;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/districtSelectorView")
    WebElement districtSelector;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/buttonSave")
    WebElement saveLocationButton;
    @AndroidFindBy(id="com.pozitron.hepsiburada:id/clContainer")
    WebElement popup;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/nav_graph_category")
    WebElement categoriesTab;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/dod_all")
    WebElement superPriceAllButton;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/nav_graph_my_list")
    WebElement listsButton;




    public void clickOnLocation(){
        wait = new WebDriverWait(driver,30);
        try{
            wait.until(ExpectedConditions.visibilityOf(location)).click();
        }catch (Exception e){
            Assertions.fail("Element not found. Case stopped");
            driver.quit();
        }

        logger.info("Clicked on Location");
    }

    public void clickCitySelector() {
        citySelector.click();
        logger.info("Clicked on City Selector");
    }



    public void clickTown() {
        townSelector.click();
        logger.info("Clicked on Town Selector");
    }



    public void clickDistrict() {
        districtSelector.click();
        logger.info("Clicked on District Selector");
    }



    public void selectItemLocationList(String arg0) {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).resourceId(\"com.pozitron.hepsiburada:id/recyclerView\"))" +
                ".scrollIntoView(new UiSelector().textContains(\""+arg0+"\"))").click();
        logger.info("Item selected: " + arg0  );
    }

    public void clickOnSaveLocationButton() {
        saveLocationButton.click();
        logger.info("Clicked on save location"  );
    }

    public void locationSavedPopupCheck() {
        Assertions.assertTrue(popup.isDisplayed());
        logger.info("Location saved successfully");
    }

    public void clickOnCategoriesTab() {
        categoriesTab.click();
        logger.info("Clicked on categories");
    }

    public void clickOnSuperPrice() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).resourceId(\"com.pozitron.hepsiburada:id/homeComponents\"))" +
                ".scrollIntoView(new UiSelector().resourceId(\"com.pozitron.hepsiburada:id/dod_title\"))");
        superPriceAllButton.click();
        logger.info("Clicked on super prices");
    }
    public void clickMyListsButton() {
        listsButton.click();
        logger.info("Clicked on my list");
    }

}
