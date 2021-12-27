package Pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    AndroidDriver driver;

    public static String getfavItemText() {
        return favItemText;
    }

    public static String getfavItemPrice() {
        return favItemPrice;
    }

    Logger logger ;
    static String favItemText="";
    static String favItemPrice="";
    public ProductPage(AndroidDriver driver){
        this.driver = driver;
        logger = LogManager.getLogger(ProductPage.class);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/productImage")
    WebElement productImage;

    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/placeHolderImage")
    List<WebElement> placeHolderImages;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/leftIcon")
    WebElement backButton;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/product_detail_favourites")
    WebElement favorites;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/productName")
    WebElement itemTitle;
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/price")
    WebElement itemPrice;



    public void clickProductImage() {
        productImage.click();
    }

    public void scrollHorizontally() {
        TouchAction touchAction = new TouchAction(driver);
        Dimension dimension =driver.manage().window().getSize();
        int height = (int) (dimension.getHeight()*0.5);
        int startingPoint = (int) (dimension.getWidth()*0.9);
        int endingPoint = (int) (dimension.getWidth()*0.1);
        for (int i = 0 ; i < placeHolderImages.size() ; i++){
            (new TouchAction(driver))
                    .longPress(LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(1)).withPosition(PointOption.point(startingPoint, height)))
                    .moveTo(PointOption.point(endingPoint,height))
                    .release()
                    .perform();
        }
        logger.info("Scrolled until the end");

    }

    public void clickBackButton() {
        backButton.click();
        logger.info("Clicked on back button");
    }

    public void clickAddToFavorites() {
        favItemText = itemTitle.getText();
        favItemPrice = itemPrice.getText();
        favorites.click();
        logger.info("Clicked on favorites button");

    }


}
