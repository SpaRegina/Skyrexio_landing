package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.back;

public class SocialIconsTest extends BaseTest {

    @DataProvider(name = "socialLinksData")
    public Object[][] socialLinksData() {
        return new Object[][]{
                {"tradingview.com", "https://www.tradingview.com/u/Skyrexio/"},
                {"t.me", "https://t.me/skyrexio"},
                {"discord.com", "https://discord.com/invite/X4cveyW"},
                {"twitter.com", "https://x.com/skyrexio"},
                {"linkedin.com", "https://www.linkedin.com/company/skyrexio"},
                {"facebook.com", "https://www.facebook.com/people/Skyrexio/61555614342628/"},
                {"youtube.com", "https://consent.youtube.com/m?continue=https%3A%2F%2Fwww.youtube.com%2F%40skyrexio%3Fcbrd%3D1&gl=DE&m=0&pc=yt&cm=2&hl=ru&src=1"},
                {"tiktok.com", "https://www.tiktok.com/@skyrexio"}
        };
    }

    @Test(description = "Проверка URL социальных иконок в футере",
            dataProvider = "socialLinksData")
    public void testSocialIconLinks(String platformHref, String expectedUrl) {
        landingPage.openPage()
                .getFooter()
                .scrollToFooter()
                .waitForFooterToLoad();

        landingPage.getSocialBlock()
                .clickSocialIcon(platformHref);

        landingPage.getSocialBlock()
                .verifyCurrentUrlIsCorrect(expectedUrl);
        back();
    }
}