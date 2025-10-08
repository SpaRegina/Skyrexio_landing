package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LandingPage;
import org.testng.annotations.Listeners;
import utils.TestListener;
import utils.PropertyReader;

import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

@Listeners(TestListener.class)
public class BaseTest {
    LandingPage landingPage;
    protected String validEmail;

    @BeforeMethod
    public void setup() {
        validEmail = PropertyReader.getProperty("valid_email");

        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10000;
        Configuration.baseUrl = "https://skyrexio.com/";
        Configuration.browserSize = "start-maximized";
        Configuration.holdBrowserOpen = true;

        landingPage = new LandingPage();
    }

    @AfterMethod
    public void closeWind() {
        clearBrowserCache();
        Selenide.closeWebDriver();
    }
}