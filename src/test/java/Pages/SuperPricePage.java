package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import java.util.List;


public class SuperPricePage {
    AndroidDriver driver;
    Logger logger ;


    public SuperPricePage(AndroidDriver driver){
        this.driver = driver;
        logger = LogManager.getLogger(SuperPricePage.class);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='com.pozitron.hepsiburada:id/pi_product_list_item_image']")
    List<WebElement> elements;
    public void selectItemWithMultipleImages() {

        WebElement elementByAndroidUIAutomator = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).resourceId(\"com.pozitron.hepsiburada:id/rv_pl_products\"))" +
                ".scrollIntoView(new UiSelector().resourceId(\"com.pozitron.hepsiburada:id/pi_product_list_item_image\"))");
        //elementByAndroidUIAutomator.findElement(By.xpath("/parent::android.widget.RelativeLayout")).click();

        driver.findElement(By.xpath("//android.view.View[@resource-id='com.pozitron.hepsiburada:id/pi_product_list_item_image']/parent::android.widget.RelativeLayout")).click();

        logger.info("Selected item with multiple images");
    }
}
