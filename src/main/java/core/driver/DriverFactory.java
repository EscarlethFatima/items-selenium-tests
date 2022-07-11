package core.driver;

import core.browser.*;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

import static core.constants.Constants.BROWSER_STACK;
import static core.constants.Constants.CHROME;

public final class DriverFactory {

    public static WebDriver getDriverManager(String driverType) {
        Map<String, Browser> map = new HashMap<>();
        map.put(CHROME, new ChromeBrowser());
        map.put(BROWSER_STACK, new MobileBrowserStack());
        return map.get(driverType).getBrowser();
    }
}
