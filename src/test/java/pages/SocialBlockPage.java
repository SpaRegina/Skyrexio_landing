package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class SocialBlockPage {

    private SelenideElement getSocialIconByHref(String platformHref) {
        return $(By.xpath(String.format("//footer//a[contains(@href, '%s')]", platformHref)));
    }

    public SocialBlockPage clickSocialIcon(String platformHref) {
        getSocialIconByHref(platformHref).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    public void verifyCurrentUrlIsCorrect(String expectedUrl) {
        webdriver().shouldHave(url(expectedUrl), Duration.ofSeconds(10));
    }
}
