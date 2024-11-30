package com.cucumber.configurations.springconfigs;

import com.cucumber.configurations.annotations.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.context.annotation.Bean;
import org.testng.asserts.SoftAssert;

@LazyConfiguration
public class CommonControlsConfig {

    @Bean
    public SoftAssert softAssert(){
        return new SoftAssert();
    }
}
