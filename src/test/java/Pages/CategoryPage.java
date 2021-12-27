package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.MyStepdefs;

import java.util.List;
import java.util.Random;

public class CategoryPage {
    AndroidDriver driver;
    Logger logger ;
    String city="";
    String town="";
    String district="";

    public CategoryPage(AndroidDriver driver){
        this.driver = driver;
        logger = LogManager.getLogger(CategoryPage.class);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/textViewLocation")
    WebElement textViewLocation;

    public void setLocation(String city,String town,String district){
        this.city = city;
        this.town = town;
        this.district = district;

    }

    public void checkIfLocationIsCorrect() {
        String getTextViewLocationText = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).resourceId(\"com.pozitron.hepsiburada:id/rv_pl_products\"))" +
                ".scrollIntoView(new UiSelector().resourceId(\"com.pozitron.hepsiburada:id/textViewLocation\"))").getText();
        logger.info("TextView Location: " + getTextViewLocationText);
        Assertions.assertEquals(city,getTextViewLocationText);
    }
}
