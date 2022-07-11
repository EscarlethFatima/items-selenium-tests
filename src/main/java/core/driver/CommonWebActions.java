package core.driver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public final class CommonWebActions {

    private WebDriverWait waiter;
    private WebDriver driver;


    public CommonWebActions(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.waiter = wait;
    }

    private  void waitWebElementVisible(final WebElement webElement) {
         waiter.until(ExpectedConditions.visibilityOf(webElement));
    }

    public boolean isWebElementDisplayed(By by, int intervalTime) {
        try {
            driver.manage().timeouts().implicitlyWait(intervalTime, TimeUnit.MILLISECONDS);
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isWebElementEnabled(WebElement webElement) {
        waitWebElementVisible(webElement);
        return  webElement.isEnabled();
    }

    public void clickElement(final WebElement element) {
        waitWebElementVisible(element);
        element.click();
    }
    public void clickElement(By by) {
        waiter.until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

    public void setTextElement(final WebElement element, final String text) {
        waitWebElementVisible(element);
        element.clear();
        element.sendKeys(text);
    }
}
