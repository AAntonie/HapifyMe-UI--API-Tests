package com.hapifyme.stepdefinition;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.*;

public class Hooks {

    private static boolean setUpDone = false;

    @Before
    public void setUp() {
        if (!setUpDone) {
            System.out.println("TEST RUN STARTED");

            Configuration.browser = "chrome";
            Configuration.baseUrl = "https://apps.qualiadept.eu/hapifyme";
            Configuration.headless = false;

            setUpDone = true;
        }

        System.out.println("SCENARIO STARTED");

        open("/login_register.php");
        webdriver().driver().getWebDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        closeWebDriver();
        System.out.println("SCENARIO FINISHED");
    }
}
