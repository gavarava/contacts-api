package com.contactsapi;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ContactsApiApplication extends Application<ContactsApiConfiguration> {

    public static void main(final String[] args) throws Exception {
        new ContactsApiApplication().run(args);
    }

    @Override
    public String getName() {
        return "ContactsApi";
    }

    @Override
    public void initialize(final Bootstrap<ContactsApiConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final ContactsApiConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
