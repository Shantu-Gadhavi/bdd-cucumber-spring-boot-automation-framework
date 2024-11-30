package com.cucumber.commoncontrols;

import com.cucumber.configurations.annotations.LazyComponent;
import com.cucumber.commonbase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@LazyComponent
public class WebPageElement extends Base {

    /**
     * Element is empty or not.
     */
    public boolean isWebElementEmpty(WebDriver driver, By by){
        return driver.findElements(by).isEmpty();
    }

    /**
     * Click Method by using JAVA Generics (You can use both By or Web element)
     */
    public <T> String getTextFromElement(WebDriver driver, T elementOrBy) {
        String text = null;
        if (elementOrBy.getClass().getName().contains("By")) {
            text = driver.findElement((By) elementOrBy).getText();
        } else {
            text = ((WebElement) elementOrBy).getText();
        }
        return text;
    }
}