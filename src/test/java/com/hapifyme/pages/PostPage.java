package com.hapifyme.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PostPage {

    // ==========
    // NAVIGATION
    // ==========

    public void open() {
        Selenide.open("/index.php");
    }

    // ==========
    // ACTIONS
    // ==========

    public void createPost(String text) {
        $("#post_text").setValue(text);
        $("#post_button").click();

        $("#post_text").shouldHave(Condition.value(""));
    }

    // ==========
    // ASSERTIONS
    // ==========

    public void shouldBeVisible() {
        $("#post_button").shouldBe(Condition.visible);
    }

    public void shouldNotBeVisible() {
        $("#post_button").shouldNotBe(Condition.visible);
    }

    public void shouldSeePost(String text) {
        $$(".post_body_content").findBy(Condition.text(text)).shouldBe(Condition.visible);
    }
}