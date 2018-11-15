package utils.device;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DeviceFactory {
    public static WebDriver getDevice(String device) {
        Map<String, String> mobileEmulation = new HashMap();
        mobileEmulation.put("deviceName", device);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver(chromeOptions);

    }
}
