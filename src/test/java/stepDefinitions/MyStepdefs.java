package stepDefinitions;

import Pages.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class MyStepdefs{
    protected static AndroidDriver driver;
    MainPage mainPage;
    CategoriesPage categoriesPage;
    CategoryPage categoryPage;
    SuperPricePage superPricePage;
    ProductPage productPage;
    LoginPage loginPage;
    ListPage listPage;

    String city="";
    String town="";
    String district="";

    @Given("{string} Isimli {string} Surumlu Cihaz ayaga kaldirilir")
    public void setup(String arg0,String arg1) throws MalformedURLException {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appPackage","com.pozitron.hepsiburada");
        desiredCapabilities.setCapability("appActivity","com.hepsiburada.ui.startup.SplashActivity");
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);

        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);

        File file = new File( System.getProperty("user.dir")+"/Hepsiburada.apk");
        desiredCapabilities.setCapability("app", file.getAbsolutePath());

        desiredCapabilities.setCapability("platformVersion",arg1);
        desiredCapabilities.setCapability("deviceName",arg0);
        desiredCapabilities.setCapability("fullReset",true);

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        if (!driver.isAppInstalled("com.pozitron.hepsiburada")){
            driver.installApp(file.getAbsolutePath());
        }
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);

    }
    @And("Konuma tiklanir")
    public void clickLocation() throws InterruptedException {
        mainPage.clickOnLocation();
    }

    @And("Il {string} secilir")
    public void ılSecilir(String arg0) {
        city=arg0;
        mainPage.clickCitySelector();
        mainPage.selectItemLocationList(arg0);
    }

    @And("Ilce {string} secilir")
    public void ılceSecilir(String arg0) {
        town=arg0;
        mainPage.clickTown();
        mainPage.selectItemLocationList(arg0);
    }
    @And("Mahalle {string} secilir")
    public void mahalleSecilir(String arg0) {
        district=arg0;
        mainPage.clickDistrict();
        mainPage.selectItemLocationList(arg0);
    }

    @And("Konum Kaydet Butonuna Tiklanir")
    public void konumKaydetButonunaTiklanir() {
        mainPage.clickOnSaveLocationButton();
    }

    @And("Konum Kaydedildi Popupi Kontrol Edilir")
    public void konumKaydedildiPopupiKontrolEdilir() {
        mainPage.locationSavedPopupCheck();
    }

    @And("Kategoriler tabina tiklanir")
    public void kategorilerTabinaTiklanir() {
        mainPage.clickOnCategoriesTab();
        categoriesPage = new CategoriesPage(driver);

    }

    @And("Kategorilerden rastgele kategori secilir")
    public void kategorilerdenRandomKategoriSecilir() {
        categoriesPage.selectRandomCategory();
        categoryPage = new CategoryPage(driver);
    }

    @And("Kategori Konumu Dogru mu Kontrol Edilir")
    public void kategoriKonumuDogruMuKontrolEdilir() {
        categoryPage.setLocation(city,town,district);
        categoryPage.checkIfLocationIsCorrect();

    }

    @And("Super Fiyata Tiklanir")
    public void superFiyataTiklanir() {
        mainPage.clickOnSuperPrice();
        superPricePage = new SuperPricePage(driver);


    }

    @And("Birden Fazla Gorselli Urun Secilir")
    public void birdenFazlaGorselliUrunSecilir() {
        superPricePage.selectItemWithMultipleImages();
    }

    @And("Urun Gorseline Tiklanir")
    public void urunGorselineTiklanir() {
        productPage = new ProductPage(driver);
        productPage.clickProductImage();
    }

    @And("Yana Dogru Scroll Edilir")
    public void yanaDogruScrollEdilir() {
        productPage.scrollHorizontally();
    }

    @And("Gorsel Ekrani Kapatilir")
    public void gorselEkraniKapatilir() {
        productPage.clickBackButton();
    }

    @And("Urun Detayda Favori Butonuna Tiklanir")
    public void urunDetaydaFavoriButonunaTiklanir() {
        productPage.clickAddToFavorites();
    }

    @And("Login Olunur")
    public void loginOlunur() {
      loginPage = new LoginPage(driver);

    }

    @And("{string} ve {string} ile login Olunur")
    public void veIleLoginOlunur(String arg0, String arg1) {
        loginPage = new LoginPage(driver);
        loginPage.login(arg0,arg1);

    }

    @And("Urun Detayda Geri Butonuna Tiklanir")
    public void urunDetaydaGeriButonunaTiklanir() {
        productPage.clickBackButton();
    }

    @And("Listelerim Butonuna Tiklanir")
    public void listelerimButonunaTiklanir() {
        mainPage.clickMyListsButton();
        listPage = new ListPage(driver);
    }

    @And("Begendiklerim Butonuna Tiklanir")
    public void begendiklerimButonunaTiklanir() {
        listPage.clickOnLikedButton();
    }

    @And("Urunun Favorilere Eklendigi Kontrol Edilir")
    public void urununFavorilereEklendigiKontrolEdilir() {
        listPage.checkIfItemAddedOnLikedItems();
    }

    @And("Cihaz kapatilir")
    public void tearDown() {
        driver.quit();
    }

}
