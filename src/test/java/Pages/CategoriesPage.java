package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class CategoriesPage {
    AndroidDriver driver;
    Logger logger ;
    public CategoriesPage(AndroidDriver driver){
        this.driver = driver;
        logger = LogManager.getLogger(CategoriesPage.class);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(id = "com.pozitron.hepsiburada:id/cardViewRecoComponent")
    List<WebElement> categories;


    public void selectRandomCategory() {
        Random random = new Random();
        int i = random.nextInt(categories.size());
        logger.info("Random Category Number : " + i);
        categories.get(i).click();


    }
}
