package com.contactsapp.bdd;

import static junit.framework.TestCase.fail;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import cucumber.api.java8.En;
import java.nio.file.Paths;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.images.builder.ImageFromDockerfile;

public class Stepdefinitions implements En {

    public static final int ADMIN_PORT = 8081;
    private GenericContainer container;
    private HttpResponse httpResponse;

    public Stepdefinitions() {

        Before(() -> startDockerContainer());

        Given("^a running Contacts Application Server$", () -> {
            if (container.isRunning()) {
                System.out
                    .println("Container with image name " + container.getDockerImageName() + " is up and running");
            } else {
                fail("Contacts Application Server for test is not running");
            }
        });

        When("^a client issues a GET to \"([^\"]*)\"$", (String resourceUri) -> {
            String apiEndpointUnderTest = "http://localhost:" + container.getMappedPort(ADMIN_PORT) + resourceUri;
            System.out.println("Healthcheck URI: " + apiEndpointUnderTest);
            HttpUriRequest request = new HttpGet(apiEndpointUnderTest);
            httpResponse = HttpClientBuilder.create().build().execute(request);
        });

        Then("^I receive \"([^\"]*)\" response$", (String arg0) -> {
            assertThat(String.valueOf(httpResponse.getStatusLine().getStatusCode()), is(arg0));
        });

        After(() -> container.stop());
    }

    private void startDockerContainer() {
        container = new GenericContainer(new ImageFromDockerfile()
            .withFileFromPath(".", Paths.get("."))).withExposedPorts(ADMIN_PORT);
        container.start();
    }
}
