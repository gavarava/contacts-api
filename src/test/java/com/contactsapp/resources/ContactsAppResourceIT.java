package com.contactsapp.resources;

import com.contactsapp.ContactsAppConfiguration;
import com.contactsapp.ContactsApplication;
import com.contactsapp.api.Contact;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.testing.DropwizardTestSupport;
import io.dropwizard.testing.ResourceHelpers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static org.glassfish.jersey.client.ClientProperties.CONNECT_TIMEOUT;
import static org.glassfish.jersey.client.ClientProperties.READ_TIMEOUT;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactsAppResourceIT {

    private static final String DEPLOYMENT_CONFIGURATION = "testDeploymentConfiguration.yaml";
    private static final DropwizardTestSupport<ContactsAppConfiguration> CONTACTS_APP_FOR_TEST = new DropwizardTestSupport<>(
            ContactsApplication.class,
            ResourceHelpers.resourceFilePath(DEPLOYMENT_CONFIGURATION));
    private static final String ENDPOINT_URL = "http://localhost:%d/";
    private static Client client;

    @BeforeEach
    void setup() throws Exception {
        CONTACTS_APP_FOR_TEST.before();
        client = new JerseyClientBuilder(CONTACTS_APP_FOR_TEST.getEnvironment()).build("TEST_CLIENT");
    }

    @Test
    void shouldReturnContactWithId() {
        Response response = client.target(
                String.format(ENDPOINT_URL + "contacts/1234", CONTACTS_APP_FOR_TEST.getLocalPort()))
                .request()
                .accept(APPLICATION_JSON)
                .get();
        client.property(CONNECT_TIMEOUT, 100);
        client.property(READ_TIMEOUT, 100);

        int status = response.getStatus();
        assertTrue(status >= 200);
        Contact contact = response.readEntity(Contact.class);
        assertNotNull(contact);
    }

    @AfterEach
    void tearDown() {
        CONTACTS_APP_FOR_TEST.after();
    }
}
