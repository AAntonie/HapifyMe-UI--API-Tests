package com.hapifyme.stepdefinition;

import io.cucumber.java.en.*;
import com.hapifyme.pages.PostPage;

public class PostSteps {

    private final PostPage feedPage = new PostPage();


    @Given("user is on feed page")
    public void user_is_on_feed_page() {
        feedPage.open();
    }

    @When("user creates a post with text {string}")
    public void user_creates_post(String text) {
        feedPage.createPost(text);
    }

    @Then("post {string} should appear on the feed")
    public void post_should_appear(String text) {
        feedPage.shouldSeePost(text);
    }
}