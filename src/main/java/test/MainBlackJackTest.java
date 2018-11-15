package test;

import assertions.MainPageAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.GamePage;
import page.MainBlackJackPage;

public class MainBlackJackTest extends AbstractTest {

    private MainBlackJackPage mainBlackJackPage;
    private MainPageAssertions mainPageAssertions;
    private GamePage gamePage;

    @BeforeMethod

    public void setUpBeforeTest() {
        mainBlackJackPage = new MainBlackJackPage(webDriver, webDriverWait);
        gamePage = new GamePage(webDriver, webDriverWait);
        mainPageAssertions = new MainPageAssertions();

    }

    @Test
    public void playSingleRoundTest() {
        mainPageAssertions.assertIsProperURL(mainBlackJackPage);
        mainBlackJackPage.acceptCookiesPolicy()
                .clickDealMeIn()
                .clickIamOver18();
        gamePage.waitForGameLoad()
                .takeASit()
                .betRandomChip()
                .play();
        gamePage.unsit()
                .close();
    }
}
