package com.hapifyme.stepdefinition;

import io.cucumber.java.en.*;
import com.hapifyme.pages.LoginPage;
import com.hapifyme.pages.PostPage;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage();
    private final PostPage PostPage = new PostPage();

    // ==========
    // NAVIGATION
    // ==========

    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage.openPage();
    }

    @Given("user is logged in")
    public void user_is_logged_in() {
        loginPage.openPage();
        loginPage.login("ana1778930304017@mail.com", "Test@123");
        PostPage.shouldBeVisible();
    }

    // ==========
    // LOGIN ACTIONS
    // ==========

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        loginPage.login("ana1778930304017@mail.com", "Test@123");
    }

    @When("user logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @When("user enters email {string}")
    public void user_enters_email(String email) {
        loginPage.enterEmail(email);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.clickLoginButton();
    }

    // ==========
    // ASSERTIONS
    // ==========

    @Then("user should be redirected to feed page")
    public void user_should_be_redirected_to_feed_page() {
        PostPage.shouldBeVisible();
    }

    @Then("login should fail and error message is displayed")
    public void login_should_fail_and_error_message_is_displayed() {
        loginPage.shouldSeeError();
    }

    @Then("user remains on login page")
    public void user_remains_on_login_page() {
        loginPage.shouldBeOnLoginPage();
        PostPage.shouldNotBeVisible();
    }

    // =================
    // EMPTY FIELD STEPS
    // =================

    @When("user leaves email field empty")
    public void user_leaves_email_field_empty() {
        // intentionally empty
    }

    @When("user leaves password field empty")
    public void user_leaves_password_field_empty() {
        // intentionally empty
    }
}