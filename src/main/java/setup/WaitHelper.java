package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WaitHelper {
    private final static int DEFAULT_TIMEOUT = 10;

    public static WaitHelper getInstance() {
        return new WaitHelper();
    }

    public WaitHelper WaitForElementToBeDisplayed(By location) {
        try {
            new WebDriverWait(DriverSetUp.getDriver(), DEFAULT_TIMEOUT).
                    until(ExpectedConditions.visibilityOfElementLocated(location));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with locator " + location.toString() + "  not found");
        }
    }

    public WaitHelper WaitForElementToBeDisplayed(WebElement webElement) {
        try {
            new WebDriverWait(DriverSetUp.getDriver(), DEFAULT_TIMEOUT).
                    until(ExpectedConditions.visibilityOf(webElement));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with locator " + webElement.toString() + "  not found");
        }
    }


    public WaitHelper WaitForElementsToBeDisplayed(List<WebElement> webElement) {
        try {
            new WebDriverWait(DriverSetUp.getDriver(), DEFAULT_TIMEOUT).
                    until(ExpectedConditions.visibilityOfAllElements(webElement));
            return this;
        } catch (WebDriverException e) {
            throw new Error("Element with locator " + webElement.toString() + "  not found");
        }
    }
}
