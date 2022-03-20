package co.com.sofka.page.Common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

public class commonActionOnPages {

    private static final Logger LOGGER = Logger.getLogger(commonActionOnPages.class);
    private static final String WEBDRIVER_NULL_MESSAGE = "\nWARNING!\n\rThe Webdriver is null, please check it.\n";
    private WebDriver driver;
    private WebDriverWait webDriverWait;


    //Constructor
    public commonActionOnPages(WebDriver driver, int Time) {
        try{
            if(driver == null)
                LOGGER.warn(WEBDRIVER_NULL_MESSAGE);

            this.driver = driver;
            webDriverWait = new WebDriverWait(driver, Time);

        } catch (Exception e){
            LOGGER.warn(e.getMessage(), e);
        }
    }

    protected void pageFactoryInitElement(WebDriver driver, Object page) {
        PageFactory.initElements(driver, page);
    }

    //Funcionalidades
    protected void clearOn(WebElement webElement){
        webDriverWait.until(elementToBeClickable(webElement)).clear();
    }
    protected void clickOn(WebElement webElement) {
        webDriverWait.until(elementToBeClickable(webElement)).click();
    }


    protected void typeOn(WebElement webElement, CharSequence... keysToSend){
            webDriverWait.until(elementToBeClickable(webElement)).sendKeys(keysToSend);
    }

    protected void scrollOn(WebElement webElement){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    protected void doSubmit(WebElement webElement){
        webDriverWait.until(elementToBeClickable(webElement)).submit();
    }

    protected String getText(WebElement webElement){
        return webDriverWait.until(elementToBeClickable(webElement)).getText();

    }


}
