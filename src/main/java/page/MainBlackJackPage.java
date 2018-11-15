package page;

import org.apache.commons.logging.Log;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MainBlackJackPage extends AbstractPage {
    private static final Logger Log = LogManager.getLogger(MainBlackJackPage.class);
    private static final String ACCEPT_COOKIE_BUTTON_ID = "cookieAccept";
    private static final String DEAL_ME_IN_BUTTON_ID = "play_iframe_button";
    private static final String I_AM_OVER_18_BUTTON_ID = "age-notice-hero-yes";

    public MainBlackJackPage(WebDriver webDriver, WebDriverWait webDriverWait) {

        super(webDriver, webDriverWait);
    }

    public String getMainURL() {
        return getPageUrl();
    }

    public MainBlackJackPage acceptCookiesPolicy() {
        clickOnElement(By.id(ACCEPT_COOKIE_BUTTON_ID));
        Log.info("ACCEPT_COOKIE_BUTTON_ID clicked");
        return this;
    }

    public MainBlackJackPage clickDealMeIn() {
        clickOnElement(By.id(DEAL_ME_IN_BUTTON_ID));
        Log.info("DEAL_ME_IN_BUTTON_ID clicked");
        return this;
    }

    public MainBlackJackPage clickIamOver18() {
        clickOnElement(By.id(I_AM_OVER_18_BUTTON_ID));
        Log.info("I_AM_OVER_18_BUTTON_ID clicked");
        return this;
    }
}
