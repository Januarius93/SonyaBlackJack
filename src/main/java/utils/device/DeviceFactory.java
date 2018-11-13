package utils.device;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeviceFactory {
    public static WebDriver getDevice() {

        return new ChromeDriver();
    }
}
