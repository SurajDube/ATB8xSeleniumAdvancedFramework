package com.thetestingacademy.tests;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class TestSelenium2 {

    @Test
    public void test_VWOLogin(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--incognito");
        edgeOptions.addArguments("--maximized");
        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/");
        driver.quit();
    }
}
