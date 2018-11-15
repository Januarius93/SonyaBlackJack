package utils.browser;

import io.github.bonigarcia.wdm.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class OperaBrowser implements Browser {
    @Override
    public WebDriver getDriver() {
        OperaDriverManager.getInstance().setup();
        return new OperaDriver();
    }
}
