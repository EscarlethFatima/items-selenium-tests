package pages;

import core.driver.CommonWebActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base {
    protected WebDriver driver;
    protected CommonWebActions webActions;
    protected WebDriverWait wait;

    public Base(WebDriver driver, CommonWebActions webActions){
        this.driver = driver;
        this.webActions = webActions;
        PageFactory.initElements(driver, this);
    }
}
