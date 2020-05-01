package com.qa.hubspot.utils;


import com.qa.hubspot.Base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class BrowserWait extends BasePage {


    public static FluentWait getFluentWait() {
        FluentWait fluentWait = new FluentWait(getDriver())
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        return fluentWait;
    }

    public static boolean waitUntilElementIsPresent(By by) {
        try {
            getFluentWait().until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }


    public static boolean waitUntilElementClickable(By by) {
        try {
            getFluentWait().until(ExpectedConditions.elementToBeClickable(by));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

}
