package com.cucumber.commoncontrols;

import com.cucumber.configurations.annotations.LazyComponent;
import com.cucumber.commonbase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@LazyComponent
public class WebTextbox extends Base {

    /**
     * Send text to web input.
     */
    public void sendTextToWebInput(WebDriver driver, By by, String textToEnter) {
        driver.findElement(by).sendKeys(textToEnter);
    }
}