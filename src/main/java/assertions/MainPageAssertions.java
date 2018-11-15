package assertions;

import org.testng.Assert;
import page.MainBlackJackPage;


public class MainPageAssertions  {

    public void assertIsProperURL(MainBlackJackPage mainBlackJackPage) {
        Assert.assertEquals(mainBlackJackPage.getMainURL(),"https://yggdrasilgaming.com/games/sonya-blackjack/");
    }
}
