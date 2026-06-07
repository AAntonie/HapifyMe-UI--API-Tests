package com.hapifyme.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.enabled;

public class RegisterPage {

    // ==============
    // NAVIGATION
    // ==============

    public void openRegisterForm() {
        $("#signup").shouldBe(visible, enabled).click();
        $(byName("reg_fname")).shouldBe(visible);
    }

    // ==============
    // FIELD ACTIONS
    // ==============

    public void enterFirstName(String fname) {
        $(byName("reg_fname")).shouldBe(visible).setValue(fname);
    }

    public void enterLastName(String lname) {
        $(byName("reg_lname")).shouldBe(visible).setValue(lname);
    }

    public void enterEmail(String email) {
        $(byName("reg_email")).shouldBe(visible).setValue(email);
    }

    public void enterConfirmEmail(String email) {
        $(byName("reg_email2")).shouldBe(visible).setValue(email);
    }

    public void enterPassword(String pass) {
        $("#reg_password").shouldBe(visible).setValue(pass);
    }

    public void enterConfirmPassword(String pass) {
        $("#reg_password2").shouldBe(visible).setValue(pass);
    }

    // =========
    // ACTIONS
    // =========

    public void clickRegister() {
        $("input[name='register_button']").shouldBe(visible, enabled).click();
    }


    public void fillRegistrationForm(String firstName, String lastName, String email, String confirmEmail, String password, String confirmPassword) {

        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterConfirmEmail(confirmEmail);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
    }

    // =========================
    // ASSERTIONS
    // =========================

    public void shouldSeeSuccessMessage() {
        $("body").shouldHave(Condition.text("You're all set! Go ahead and login!"));
    }

    public void shouldSeeErrorMessage(String message) {
        $("body").shouldHave(Condition.text(message));
    }
}