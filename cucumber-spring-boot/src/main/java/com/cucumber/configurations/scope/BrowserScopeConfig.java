package com.cucumber.configurations.scope;

import com.cucumber.configurations.annotations.LazyConfiguration;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class BrowserScopeConfig {

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor(){

        return new BrowserScopePostProcessor();
    }
}
