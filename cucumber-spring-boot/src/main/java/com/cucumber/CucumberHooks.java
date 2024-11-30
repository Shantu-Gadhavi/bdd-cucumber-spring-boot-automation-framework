package com.cucumber;

import com.cucumber.commonbase.Base;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;

public class CucumberHooks extends Base {

    @Value("${SITE_URL}") private String SITE_URL;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all executed.");
    }

    @Before
    public void setUp(Scenario scenario) {
        CucumberHooks.scenario = scenario;
        this.ctx.getBean(WebDriver.class).manage().window().maximize();
        this.ctx.getBean(WebDriver.class).get(SITE_URL);

    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            scenario.attach(screenshotService.getScreenshot(), "image/png", scenario.getName());
        }
        this.ctx.getBean(WebDriver.class).quit();
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("after all step generated.");
    }
}