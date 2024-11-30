package com.cucumber.commonservices;

import com.cucumber.commonbase.Base;
import com.cucumber.configurations.annotations.LazyComponent;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

@LazyComponent
public class ScreenshotService extends Base {

    public byte[] getScreenshot(){
        return this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
    }
}
