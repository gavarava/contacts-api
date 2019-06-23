package com.contactsapp;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import io.dropwizard.testing.DropwizardTestSupport;
import io.dropwizard.testing.ResourceHelpers;
import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.jupiter.api.Test;

class ContactsApplicationIT {

    private static final String DEPLOYMENT_CONFIGURATION = "testDeploymentConfiguration.yaml";
    private static final DropwizardTestSupport<ContactsAppConfiguration> CONTACTS_APP_FOR_TEST = new DropwizardTestSupport<>(
        ContactsApplication.class,
        ResourceHelpers.resourceFilePath(DEPLOYMENT_CONFIGURATION));

    @Test
    void shouldRespondToHealthEndpointOnStartup() {
        CONTACTS_APP_FOR_TEST.before();
        Client client = new JerseyClientBuilder().build();
        Response response = client.target(
            String.format("http://localhost:%d/healthcheck", CONTACTS_APP_FOR_TEST.getLocalPort()))
            .request()
            .get();
        assertThat(response.getStatus(), is(200));
        CONTACTS_APP_FOR_TEST.after();
    }

}