package ui;

import core.driver.CommonWebActions;
import core.driver.DriverFactory;
import core.utils.PropertiesManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static core.constants.Constants.BROWSER;
import static core.constants.Constants.URL;

public class BaseTests {
    protected static WebDriver driver;
    protected static CommonWebActions webActions;
    protected static WebDriverWait wait;

    @BeforeClass
    public static void setupClass() {
        driver = DriverFactory.getDriverManager(PropertiesManager.getInstance().getProperties(BROWSER));
        wait = new WebDriverWait(driver, 10, 100);
        webActions = new CommonWebActions(driver, wait);
        driver.get(PropertiesManager.getInstance().getProperties(URL));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
