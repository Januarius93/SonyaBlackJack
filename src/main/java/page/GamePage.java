package page;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GamePage extends AbstractPage {

    private static final String SONYA_BLACK_JACK_TITLE = "//span[contains(text(),'Sonya Blackjack')]";
    private static final String TAKE_SITS_CLASS_NAME = "takeSit";
    private static final String CHIP_CLASS_CLASS_NAME = "chip";
    private static final String HIT_BUTTON_XPATH = "//*[@id=\"game\"]/div/div/div[2]/div[3]/div[3]/button";
    private static final String STAND_BUTTON_XPATH = "//*[@id=\"game\"]/div/div/div[2]/div[3]/div[2]/button";
    private static final String REBET_BUTTON_XPATH = "//*[@id=\"game\"]/div/div/div[2]/div[3]/div[5]/button";
    private static final String LEAVE_BUTTON_XPATH = "//*[@id=\"game\"]/div/div/div[2]/div[3]/div[6]/button";
    private static final String DEAL_BUTTON_XPATH = "//*[@id=\"game\"]/div/div/div[2]/div[3]/div[3]/button";
    private static final String CLOSE_BUTTON_CLASS = "hero-section__close-button";
    private static final String WIN_ANIMATION_CLASS = " winAnimationText ";


    public GamePage(WebDriver webDriver, WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    private static final Logger Log = LogManager.getLogger(AbstractPage.class);

    public GamePage waitForGameLoad() {
        switchToFrameByIndex(0);
        Log.info("switched to frame 0");
        waitForGivenElementToAppear(SONYA_BLACK_JACK_TITLE);
        Log.info("game loaded");
        return this;
    }

    public GamePage takeASit() {
        clickOnRandomElement(TAKE_SITS_CLASS_NAME);
        Log.info("sit taken");
        return this;
    }

    public GamePage unsit() {
        clickOnElement(By.xpath(LEAVE_BUTTON_XPATH));
        Log.info("game has been left");
        return this;
    }

    public GamePage close() {
        clickOnElement(By.className(CLOSE_BUTTON_CLASS));
        Log.info("game has been closed");
        return this;
    }

    public GamePage betRandomChip() {
        clickOnRandomElement(CHIP_CLASS_CLASS_NAME);
        Log.info("bet given");
        clickOnElement(By.xpath(DEAL_BUTTON_XPATH));
        Log.info("waiting for other players...");
        return this;
    }


    public boolean play() {
        boolean gameEndFlag;
        while (true) {
            try {
                if (isElementDisplayed(By.className(CHIP_CLASS_CLASS_NAME))) {
                    Log.info("CHIP_CLASS_CLASS_NAME is displayed");
                    betRandomChip();
                }

                if (isElementEnabled(By.xpath(HIT_BUTTON_XPATH))) {
                    Log.info("CHIP_CLASS_CLASS_NAME is enabled");
                    clickOnElement(By.xpath(HIT_BUTTON_XPATH));
                    Log.info("HIT_BUTTON_XPATH clicked");
                }

                if (isElementEnabled(By.xpath(STAND_BUTTON_XPATH))) {
                    Log.info("STAND_BUTTON_XPATH is enabled");
                    clickOnElement(By.xpath(STAND_BUTTON_XPATH));
                    Log.info("STAND_BUTTON_XPATH clicked");
                }

                if (isElementEnabled(By.xpath(REBET_BUTTON_XPATH))) {
                    Log.info("REBET_BUTTON_XPATH is enabled");
                    clickOnElement(By.xpath(REBET_BUTTON_XPATH));
                    Log.info("REBET_BUTTON_XPATH clicked");
                }

                if (isElementDisplayed(By.className(WIN_ANIMATION_CLASS))) {
                    Log.warn("Game is over");
                    gameEndFlag = true;
                    break;
                }
            } catch (StaleElementReferenceException e) {
                System.out.println("stale reference caught");
            } catch (ElementNotVisibleException e) {
                System.out.println("not visible caught");
            } catch (NoSuchElementException e) {
            }

        }

        return gameEndFlag;
    }
}
