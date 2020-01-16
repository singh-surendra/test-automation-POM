package com.qa.hubspot.tests;

import com.qa.hubspot.Base.BasePage;
import com.qa.hubspot.baseTest.BaseTest;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.listeners.TestAllureListener;
import com.qa.hubspot.pages.login.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.Properties;

@Listeners({TestAllureListener.class})
@Owner("Surendra Singh")
public class LoginTests extends BaseTest {


    LoginPage loginPage = new LoginPage();


    @Test(priority = 1, description = "verifying login page title")

    @Severity(SeverityLevel.NORMAL)
    @Description("Test Case Description: Verify login page title test on Login Page")
    @Story("Story Name: To check login page title")
    @Flaky
    public void verifyLoginPageTitleTest() {
        String title = loginPage.getLoginPageTitle();
        Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);

    }


    @Test(priority = 2, description = "verifying sign up link test")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Case Description: Verify verify SignUp Link Test on Login Page")
    @Story("Story Name: To check sign up link")
    public void verifySignUpLinkTest() {
        Assert.assertTrue(loginPage.verifySignUpLink());
    }


    @Title("login success")
    @Test(priority = 3, description = "login into app test")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Case Description: verify login into application with correct credentials")
    @Story("Story Name: To check login functionality")
    public void loginCorrectCredentialsTest() {
        loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test(priority = 4,successPercentage = 40, description = "Test imp")
    public void testSuccessPercentage(){
        String title = loginPage.getLoginPageTitle();
        Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
        Assert.assertTrue(loginPage.verifySignUpLink());

    }


}
