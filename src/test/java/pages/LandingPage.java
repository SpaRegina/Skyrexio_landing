package pages;

public class LandingPage {

    public LandingPage openPage() {
        com.codeborne.selenide.Selenide.open("/");
        return this;
    }

    public FooterPage getFooter() {
        return new FooterPage();
    }
}
