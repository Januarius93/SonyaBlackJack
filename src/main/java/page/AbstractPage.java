package page;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.RandomPickerMachine;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPage {
    private static final Logger Log = LogManager.getLogger(AbstractPage.class);
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    int randomValue;
    List elementsList = new ArrayList();

    public AbstractPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }


    String getPageUrl() {
        return webDriver.getCurrentUrl();
    }

    void clickOnElement(By elementToClick) {
        if (isElementPresent(elementToClick)) {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(elementToClick));
            webDriver.findElement(elementToClick).click();
        }
    }

    void clickOnWebElement(WebElement webElement) {
        webElement.click();

    }

    public boolean isElementPresent(By element) {
        try {
            webDriver.findElement(element);
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean isElementDisplayed(By element) {
        return webDriver.findElement(element).isDisplayed();
    }

    public boolean isElementEnabled(By element) {
        return webDriver.findElement(element).isEnabled();
    }

    void waitForGivenElementToAppear(String element) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }

    void switchToFrameByIndex(int index) {
        webDriver.switchTo().frame(index);
    }

    List<WebElement> getElementsByClassName(String name) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className(name)));
        return webDriver.findElements(By.className(name));
    }

    void clickOnRandomElement(String locator) {
        elementsList = getElementsByClassName(locator);
        randomValue = new RandomPickerMachine(elementsList.size()).pickRandomValue();
        WebElement element = getElementFromArray(elementsList, randomValue);
        Log.info(randomValue+ " choosen");
        clickOnWebElement(element);
    }

    WebElement getElementFromArray(List<WebElement> elementList, int index) {
        return elementList.get(index);
    }


}
