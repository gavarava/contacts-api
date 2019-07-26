package com.contactsapp.bdd;

import cucumber.api.java8.En;
import java.nio.file.Paths;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.images.builder.ImageFromDockerfile;

public class Stepdefinitions implements En {

    private GenericContainer container;

    public Stepdefinitions() {

        Given("^a running Contacts Application Server$", () -> {
            startDockerContainer();
        });

        When("^I issue a POST to /healthcheck$", () -> {
        });

        Then("^I receive \"([^\"]*)\" response$", (String arg0) -> {
        });

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

        After(() -> container.stop());

    }

    private void startDockerContainer() {
        container = new GenericContainer(new ImageFromDockerfile()
            .withFileFromPath(".", Paths.get(".")));
        container.start();
    }
}
