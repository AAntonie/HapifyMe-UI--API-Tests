package com.hapifyme.stepdefinition;

import com.hapifyme.pages.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.Map;

public class RegisterSteps {

    private final RegisterPage registerPage = new RegisterPage();
    private String generatedEmail;

    // ==========
    // NAVIGATION
    // ==========

    @Given("I am on the registration page")
    public void openPage() {
        registerPage.openRegisterForm();
    }

    // =================
    // POSITIVE SCENARIO
    // =================

    @When("I enter first name {string}")
    public void firstName(String fname) {
        registerPage.enterFirstName(fname);
    }

    @When("I enter last name {string}")
    public void lastName(String lname) {
        registerPage.enterLastName(lname);
    }

    @When("I enter email {string}")
    public void email(String emailPrefix) {
        generatedEmail = emailPrefix + System.currentTimeMillis() + "@mail.com";
        registerPage.enterEmail(generatedEmail);
    }

    @When("I enter confirm email")
    public void confirmEmail() {
        registerPage.enterConfirmEmail(generatedEmail);
    }

    @When("I enter password {string}")
    public void password(String pass) {
        registerPage.enterPassword(pass);
    }

    @When("I enter confirm password {string}")
    public void confirmPassword(String pass) {
        registerPage.enterConfirmPassword(pass);
    }

    @When("I click on register button")
    public void clickRegister() {
        registerPage.clickRegister();
    }

    // =================
    // DATA TABLE FLOW
    // =================

    @When("I try to register with:")
    public void registerWithDataTable(DataTable table) {

        Map<String, String> row = table.asMaps().get(0);

        String email = "ana" + System.currentTimeMillis() + "@mail.com";

        registerPage.fillRegistrationForm(
                "Ana",
                "Test",
                email,
                email,
                row.get("password"),
                row.get("confirmPassword")
        );

        registerPage.clickRegister();
    }


    @Then("I should see registration success message")
    public void successMessage() {
        registerPage.shouldSeeSuccessMessage();
    }

    @Then("I should see error message {string}")
    public void errorMessage(String message) {
        registerPage.shouldSeeErrorMessage(message);
    }
}