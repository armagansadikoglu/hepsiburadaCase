package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import java.util.List;


public class ListPage {
    AndroidDriver driver;
    Logger logger ;
    public ListPage(AndroidDriver driver){
        this.driver = driver;
        logger = LogManager.getLogger(ListPage.class);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath = "//android.view.View[contains(@resource-id,'MyListBox')]")
    List<WebElement> lists;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Sırala']")
    WebElement sortButton;

    @AndroidFindBy(xpath = " //android.view.View[@text='En son eklenen']")
    WebElement lastAddedButton;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='root']/android.widget.ListView/android.view.View[1]/android.view.View[2]")
    WebElement likedItem;




    public void clickOnLikedButton() {
        lists.get(0).click();
    }

    public void checkIfItemAddedOnLikedItems() {
        sortButton.click();
        lastAddedButton.click();
        likedItem.click();

        logger.info("Recorded Price" + ProductPage.getfavItemPrice());
        logger.info("Recorded Title" + ProductPage.getfavItemText());

        ProductPage productPage = new ProductPage(driver);
        String itemPrice = productPage.itemPrice.getText();
        String itemTitle = productPage.itemTitle.getText();
        logger.info("Item Price" + itemPrice);
        logger.info("Item Title" + itemTitle);
        productPage.clickAddToFavorites();
        logger.info("Item Removed From Favorites for retest");
        productPage.clickBackButton();


        Assertions.assertEquals(itemPrice,ProductPage.getfavItemPrice());
        Assertions.assertEquals(itemTitle,ProductPage.getfavItemText());
        logger.info("Recorded and actual datas are equal");
        

    }
}
