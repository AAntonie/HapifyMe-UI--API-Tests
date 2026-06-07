package com.hapifyme.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private final SelenideElement emailInput = $("#emailId");
    private final SelenideElement passwordInput = $("#passwordId");
    private final SelenideElement loginButton = $("input[name='login_button']");
    private final SelenideElement errorMessage = $("#log_inv");

    // ==========
    // NAVIGATION
    // ==========

    public void openPage() {
        open("https://apps.qualiadept.eu/hapifyme/login_register.php");
        emailInput.shouldBe(Condition.visible);
    }

    // =======
    // ACTIONS
    // =======

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public void enterEmail(String email) {
        emailInput.shouldBe(Condition.visible).setValue(email);
    }

    public void enterPassword(String password) {
        passwordInput.shouldBe(Condition.visible).setValue(password);
    }

    public void clickLoginButton() {
        loginButton.shouldBe(Condition.enabled).click();
    }

    // ==========
    // ASSERTIONS
    // ==========

    public void shouldBeOnLoginPage() {
        emailInput.shouldBe(Condition.visible);
        passwordInput.shouldBe(Condition.visible);
        loginButton.shouldBe(Condition.visible);
    }

    public void shouldBeLoggedIn() {
        $("#feed, .feed, body").shouldBe(Condition.visible);
    }

    public void shouldSeeError() {
        errorMessage.shouldBe(Condition.visible);
    }
}