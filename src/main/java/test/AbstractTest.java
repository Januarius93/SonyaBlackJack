package test;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import utils.browser.BrowserFactory;
import utils.device.DeviceFactory;


public class AbstractTest {
    WebDriver webDriver;


    @Parameters({"url","browser", "emulator", "device"})
    @BeforeClass(alwaysRun = true)
    public void initiate(String url, String browser, String emulator, String device) {
        if (emulator.equalsIgnoreCase("on")) {
            webDriver = DeviceFactory.getDevice();
        } else {
            webDriver = BrowserFactory.getBrowser(browser);
        }
        maximize();
        openBrowser(url);
    }



    private void openBrowser(String url){
        webDriver.get(url);
    }

    private void maximize(){
        webDriver.manage().window().maximize();
    }

    @AfterClass
    public void tearDownAfterClass() {
        webDriver.quit();
    }

}
