package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class FooterPage {
    private final SelenideElement emailInput = $("footer input[type='email']");
    private final SelenideElement subscribeButton = $("footer button[type='submit']");
    private final SelenideElement successMessage = $(".elementor-message-success");

    public FooterPage scrollToFooter() {
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        sleep(3000);
        return this;
    }

    public FooterPage enterEmail(String email) {
        emailInput.shouldBe(Condition.visible).setValue(email);
        return this;
    }

    public FooterPage clickSubscribe() {
        subscribeButton.shouldBe(Condition.enabled).click();
        return this;
    }

    public void verifySuccessMessage() {
        successMessage.shouldBe(Condition.visible);
        emailInput.shouldHave(Condition.empty);
    }
}
