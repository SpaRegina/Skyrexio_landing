package tests;

import org.testng.annotations.Test;

public class SubscriptionTest extends BaseTest {

    @Test
    public void testSubscriptionValidEmail() {
        landingPage.openPage()
                .getFooter()
                .scrollToFooter()
                .enterEmail(validEmail)
                .clickSubscribe()
                .verifySuccessMessage();
    }
}