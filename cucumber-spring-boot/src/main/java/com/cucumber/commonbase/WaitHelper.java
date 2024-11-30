package com.cucumber.commonbase;

import com.cucumber.configurations.annotations.LazyComponent;

@LazyComponent
public class WaitHelper extends Base {

    public void waitForElement() {
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println("wait issue.");
        }
    }
}