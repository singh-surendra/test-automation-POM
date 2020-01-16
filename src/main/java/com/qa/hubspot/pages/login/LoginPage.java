package com.qa.hubspot.pages.login;

import com.qa.hubspot.utils.BrowserWait;
import io.qameta.allure.Step;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import static com.qa.hubspot.pages.login.LoginPageLocators.*;
import static com.qa.hubspot.utils.BrowserActions.*;



@Slf4j
public class LoginPage extends BrowserWait {



    @Step("getting login page title step....")
    public String getLoginPageTitle() {
        waitUntilElementIsPresent(SIGN_UP_LINK_TEXT);
        return driver.getTitle();
    }


    @Step("verifying sign up link is displayed step....")
    public boolean verifySignUpLink(){
        return waitUntilElementIsPresent(SIGN_UP_LINK_TEXT);
    }


    public  void login(String un, String pwd){
        waitUntilElementIsPresent(LOGIN_BTN_XPATH);
        enterEmail(un);
        enterPassword(pwd);
        clickLoginButton();
    }



    public void enterEmail(@NonNull String email) {
        log.info("entering email address");
        waitUntilElementIsPresent(EMAIL_FIELD_XPATH);
        clearAndfillInFieldWith(EMAIL_FIELD_XPATH, email);

    }


    public void enterPassword(@NonNull String password) {
        log.info("entering password");
        waitUntilElementIsPresent(PASSWORD_FIELD_XPATH);
        clearAndfillInFieldWith(PASSWORD_FIELD_XPATH, password);
    }


    public void clickLoginButton() {
        log.info("Clicking login button");
        waitUntilElementClickable(LOGIN_BTN_XPATH);
        clickElementBy(LOGIN_BTN_XPATH);
    }

}
