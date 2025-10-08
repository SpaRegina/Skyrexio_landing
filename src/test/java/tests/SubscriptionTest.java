package tests;

import org.testng.annotations.Test;

public class SubscriptionTest extends BaseTest {

    @Test
    public void testSubscriptionValidEmail() {
        landingPage.openPage()
                .getFooter()
                .scrollToFooter()
                .waitForFooterToLoad()
                .enterEmail(validEmail)
                .clickSubscribe()
                .verifySuccessMessage();
    }
}