package com.qa.hubspot.pages.login;

import org.openqa.selenium.By;

public class LoginPageLocators {

    public static final By LOGIN_BTN_XPATH         = By.xpath("//*[contains(text(),'Log in')]");
    public static final By EMAIL_FIELD_XPATH       = By.xpath("//input[@type='email']");
    public static final By PASSWORD_FIELD_XPATH    = By.xpath("//input[@type='password']");
    public static final By SIGN_UP_LINK_TEXT    = By.linkText("Sign up");


}
