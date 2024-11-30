package com.cucumber.commoncontrols;

import com.cucumber.configurations.annotations.LazyComponent;
import com.cucumber.commonbase.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@LazyComponent
public class WebButton extends Base {

    /**
     * Click Method by using JAVA Generics (You can use both By or Web element)
     */
    public <T> void click(WebDriver driver, T elementOrBy) {
        if (elementOrBy.getClass().getName().contains("By")) {
            driver.findElement((By) elementOrBy).click();
        } else {
            ((WebElement) elementOrBy).click();
        }
    }
}
