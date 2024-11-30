package com.cucumber.commonbase;

import com.cucumber.commoncontrols.*;
import com.cucumber.commonservices.ScreenshotService;
import com.cucumber.configurations.annotations.LazyAutowired;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.testng.asserts.SoftAssert;

public abstract class Base {

    @LazyAutowired
    protected WebDriver driver;
    @LazyAutowired
    protected SoftAssert softAssert;
    @LazyAutowired
    protected WebButton webButton;
    @LazyAutowired
    protected WebPageElement webPageElement;
    @LazyAutowired
    protected WebTextbox webTextbox;
    @LazyAutowired
    protected WaitHelper waitHelper;
    @LazyAutowired
    protected ApplicationContext ctx;
    @LazyAutowired
    protected ScreenshotService screenshotService;

    public static Scenario scenario;

}
