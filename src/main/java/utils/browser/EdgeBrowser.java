package utils.browser;

import io.github.bonigarcia.wdm.EdgeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeBrowser implements Browser {
    @Override
    public WebDriver getDriver() {
        EdgeDriverManager.getInstance().setup();
        return new EdgeDriver();
    }
}
