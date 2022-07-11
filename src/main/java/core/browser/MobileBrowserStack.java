package core.browser;

import core.utils.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static core.constants.Constants.*;
import static core.constants.Constants.REMOTE_ACCESS_KEY;


public class MobileBrowserStack implements Browser {

    private static final String USERNAME = PropertiesManager.getInstance().getProperties(REMOTE_USER_NAME);
    private static final String ACCESS_KEY = PropertiesManager.getInstance().getProperties(REMOTE_ACCESS_KEY);
    private static final String URL =
            String.format("http://%s:%s@hub-cloud.browserstack.com/wd/hub", USERNAME, ACCESS_KEY);

    private DesiredCapabilities setCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browserName", PropertiesManager.getInstance().getProperties(REMOTE_BROWSER_NAME));
        caps.setCapability("device", PropertiesManager.getInstance().getProperties(REMOTE_DEVICE));
        caps.setCapability("realMobile", PropertiesManager.getInstance().getProperties(REMOTE_REAL_MOBILE));
        caps.setCapability("os_version", PropertiesManager.getInstance().getProperties(REMOTE_OS_VERSION));
        return caps;
    }

    @Override
    public WebDriver getBrowser() {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(URL), setCapabilities());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
