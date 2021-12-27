package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.MyStepdefs;

import java.util.List;
import java.util.Random;
import java.util.Set;

public class LoginPage {
    AndroidDriver driver;
    Logger logger ;
    WebDriverWait wait;


    public LoginPage(AndroidDriver driver){
        this.driver = driver;
        logger = LogManager.getLogger(LoginPage.class);
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='txtUserName']")
    WebElement txtUserName;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='btnLogin']")
    WebElement btnLogin;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='txtPassword']")
    WebElement  txtPassword;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='btnEmailSelect']")
    WebElement  btnEmailSelect;

    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='android:id/button1']")
    WebElement okButton;

    public void login(String email, String password) {

        wait = new WebDriverWait(driver,30);

        try{
            wait.until(ExpectedConditions.visibilityOf(txtUserName)).sendKeys(email);
            btnLogin.click();
            wait.until(ExpectedConditions.visibilityOf(txtPassword)).sendKeys(email);
            btnEmailSelect.click();
        }catch (Exception e){
            Assertions.fail("Element not found. Case stopped");
            driver.quit();
        }


        if ( wait.until(ExpectedConditions.visibilityOf(okButton)).isDisplayed()){
            okButton.click();
            logger.info("Login Successful for " + email);
        }else{

            logger.error("Login Not Successful for " + email);
            driver.quit();
        }


    }
}
