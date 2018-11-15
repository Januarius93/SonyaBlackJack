package test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import utils.browser.BrowserFactory;
import utils.device.DeviceFactory;


public abstract class AbstractTest {
    WebDriver webDriver;
    WebDriverWait webDriverWait;


    @Parameters({"url", "browser", "emulator", "device"})
    @BeforeSuite(alwaysRun = true)
    public void initiate(String url, String browser, String emulator, String device) {


        if (emulator.equalsIgnoreCase("on")) {
            webDriver = DeviceFactory.getDevice(device);
        } else {
            webDriver = BrowserFactory.getBrowser(browser);
        }
        webDriverWait = new WebDriverWait(webDriver, 40);
        maximize();
        openBrowser(url);
    }


    private void openBrowser(String url) {
        webDriver.get(url);
    }

    private void maximize() {
        webDriver.manage().window().maximize();
    }

    @AfterSuite
    public void tearDownAfterClass() {
        webDriver.quit();
    }

}
