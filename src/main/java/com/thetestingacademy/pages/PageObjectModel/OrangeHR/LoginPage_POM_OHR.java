package com.thetestingacademy.pages.PageObjectModel.OrangeHR;

import com.thetestingacademy.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.thetestingacademy.utils.PropertiesReader;

import java.io.IOException;

public class LoginPage_POM_OHR extends CommonToAllPage {


    // param cons
    WebDriver driver;

    public LoginPage_POM_OHR(WebDriver driver) {
        this.driver = driver;
    }


    // page locators
    private By username = By.xpath("//input[@placeholder='Username']");
    private By password = By.xpath("//input[@placeholder='Password']");
    private By submit_btn = By.xpath("//button[normalize-space()='Login']");


    // page actions

    public void loginToHRCreds(String user, String pwd) throws IOException {
        driver.get(PropertiesReader.readKey("orange_hr_url"));
        visibilityOfElement(username);
        enterInput(username, user);
        enterInput(password, pwd);
        clickElement(submit_btn);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }


}
