package com.contactsapp;

import com.contactsapp.service.health.ContactsAppHealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ContactsApplication extends Application<ContactsAppConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ContactsApplication().run(args);
    }

    @Override
    public String getName() {
        return "ContactsApi";
    }

    @Override
    public void initialize(final Bootstrap<ContactsAppConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final ContactsAppConfiguration configuration,
        final Environment environment) {
        environment.healthChecks().register("healthcheck", new ContactsAppHealthCheck());
    }

}
