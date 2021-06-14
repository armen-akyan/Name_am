package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import setup.WaitHelper;

import static setup.DriverSetUp.getDriver;

public abstract class BasePage<T> {

    public static final Logger LOGGER = Logger.getLogger(BasePage.class);

    public BasePage() {
        getDriver();
    }

    public abstract String getUrl();

    protected T initPage() {
        PageFactory.initElements(getDriver(), this);
        LOGGER.info("Initialising to " + getDriver().getCurrentUrl());
        return (T) this;
    }

    protected final void open() {
        openByURL(getUrl());
    }

    protected void openByURL(String url) {
        LOGGER.info("Opening URL -> " + url);
        getDriver().get(url);
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            LOGGER.info("Making sure that element is displayed -> " + element.toString());
            WaitHelper.getInstance().WaitForElementToBeDisplayed(element);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void type(WebElement element, String text) {
        LOGGER.info("Typing " + text + " in -> " + element.toString());
        WaitHelper.getInstance().WaitForElementToBeDisplayed(element);
        element.sendKeys(text);
    }

    protected void click(WebElement element) {
        LOGGER.info("Clicking on -> " + element.toString());
        WaitHelper.getInstance().WaitForElementToBeDisplayed(element);
        element.click();
    }


}
