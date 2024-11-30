package com.cucumber.configurations.springconfigs;

import com.cucumber.configurations.annotations.LazyConfiguration;
import com.cucumber.configurations.annotations.LocalThreadScope;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@LazyConfiguration
public class WebDriverConfig {

    @LocalThreadScope
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver(){
        FirefoxOptions option = new FirefoxOptions();
        return new FirefoxDriver(option);
    }

    @LocalThreadScope
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    public WebDriver edgeDriver(){
        EdgeOptions options = new EdgeOptions();
        return new EdgeDriver(options);
    }

    @LocalThreadScope
//    @ConditionalOnMissingBean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public WebDriver chromeDriver(){
        ChromeOptions option = new ChromeOptions();
        return new ChromeDriver(option);
    }
}
