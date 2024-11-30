package com.cucumber.pages;

import com.cucumber.commonbase.Base;
import com.cucumber.configurations.annotations.LazyComponent;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;

@LazyComponent
public class LoginPage extends Base {

    @Value("${USER_NAME}") private String USER_NAME;
    @Value("${PASSWORD}") private String PASSWORD;

    private final By userNameTextbox = By.id("user-name");
    private final By passwordTextbox = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By productsLabel = By.xpath("//*[@id='header_container']//span[@class='title']");


    public void enterUserName() {
        webTextbox.sendTextToWebInput(driver, userNameTextbox, USER_NAME);
    }

    public void enterPassword(){
        webTextbox.sendTextToWebInput(driver, passwordTextbox, PASSWORD);
    }

    public void clickLoginButton(){
        webButton.click(driver, loginButton);
    }

    public boolean verifyProductsPage(){
        return !webPageElement.isWebElementEmpty(driver, productsLabel);
    }
}
