package com.contactsapp;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import com.contactsapp.api.Contact;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.testing.DropwizardTestSupport;
import io.dropwizard.testing.ResourceHelpers;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.jetty.http.HttpStatus;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.jupiter.api.Test;

class ContactsApplicationIT {

    private static final String DEPLOYMENT_CONFIGURATION = "testDeploymentConfiguration.yaml";
    private static final DropwizardTestSupport<ContactsAppConfiguration> CONTACTS_APP_FOR_TEST = new DropwizardTestSupport<>(
        ContactsApplication.class,
        ResourceHelpers.resourceFilePath(DEPLOYMENT_CONFIGURATION));

    @Test
    void shouldRespondToHealthcheckResourceAtAdminPortOnStartup() {
        CONTACTS_APP_FOR_TEST.before();
        Client client = new JerseyClientBuilder().build();
        Response response = client.target(
            String.format("http://localhost:%d/healthcheck", CONTACTS_APP_FOR_TEST.getAdminPort()))
            .request()
            .get();
        assertThat(response.getStatus(), is(HttpStatus.OK_200));
        CONTACTS_APP_FOR_TEST.after();
    }

    @Test
    void shouldStoreContact() throws JsonProcessingException {
        CONTACTS_APP_FOR_TEST.before();
        Client client = new JerseyClientBuilder().build();
        Contact contact = new Contact("Marlyin", "Mansson", "16 Grev Turegatan", "96122", "STO", "010-152-911");
        ObjectMapper objectMapper = new ObjectMapper();
        String contactJSONString = objectMapper.writeValueAsString(contact);
        Entity<String> entity = Entity.entity(contactJSONString, MediaType.APPLICATION_JSON);
        Response response = client.target(
            String.format("http://localhost:%d/contacts/contact", CONTACTS_APP_FOR_TEST.getLocalPort()))
            .request()
            .post(entity);
        assertThat(response.getStatus(), is(HttpStatus.CREATED_201));
        CONTACTS_APP_FOR_TEST.after();
    }

}