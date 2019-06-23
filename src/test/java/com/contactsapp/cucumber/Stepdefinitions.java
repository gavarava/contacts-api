package com.contactsapp.cucumber;

import cucumber.api.java8.En;

public class Stepdefinitions implements En {

  public Stepdefinitions() {
    Given(
        "^a JSON object with <firstName>, <lastName>, <address>, <postcode>, <city>, <phoneNumber>$",
        () -> {
        });
    When("^I issue a POST to /contacts$", () -> {
    });
    Then("^I receive a (\\d+) Status code$", (Integer arg0) -> {
    });
    And("^a JSON with message \"([^\"]*)\"$", (String arg0) -> {
    });
  }
}
