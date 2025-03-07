package com.thetestingacademy.tests.vwoLogin.PageObjectModel_TestCase;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.PageObjectModel.vwo.DashboardPage_POM;
import com.thetestingacademy.pages.PageObjectModel.vwo.LoginPage_POM;
import com.thetestingacademy.tests.vwoLogin.pageFactory_TestCase.TestVWOLogin_PF;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin_POM extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF.class);

    @Owner("Suraj Dubey")
    @Description("Verify that invalid credentials give error message")
    @Test
    public void testLoginNegativeVWO() throws Exception{
        logger.info("Starting the Testcases Page Factory");
        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        String error_msg = loginPagePom.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg, PropertiesReader.readKey("error_message"));
        logger.info("End of the Testcase!!");
    }

    @Owner("Suraj Dubey")
    @Description("Verify that invalid credentials give error message")
    @Test
    public void testPositive() throws IOException {
        logger.info("Starting the Testcases Page Factory");
        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        loginPagePom.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPage_POM dashboardPagePom = new DashboardPage_POM(DriverManager.getDriver());
        String loggedInUserName = dashboardPagePom.loggedInUserName();

        assertThat(loggedInUserName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedInUserName, PropertiesReader.readKey("expected_username"));
        logger.info("End of the Testcase!!");
    }
}
