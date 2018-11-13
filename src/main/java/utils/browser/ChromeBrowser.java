package utils.browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowser implements Browser {

    @Override
    public WebDriver getDriver() {
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver();
    }
}
