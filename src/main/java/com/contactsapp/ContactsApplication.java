package com.contactsapp;

import com.contactsapp.api.Contact;
import com.contactsapp.health.ContactsAppHealthCheck;
import com.contactsapp.modules.ContactsServiceModule;
import com.fasterxml.jackson.databind.DeserializationFeature;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class ContactsApplication extends Application<ContactsAppConfiguration> {

    private final HibernateBundle<ContactsAppConfiguration> hibernate = new HibernateBundle<ContactsAppConfiguration>(
        Contact.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(ContactsAppConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    public static void main(final String[] args) throws Exception {
        new ContactsApplication().run(args);
    }

    @Override
    public String getName() {
        return "ContactsApi";
    }

    @Override
    public void initialize(final Bootstrap<ContactsAppConfiguration> bootstrap) {
        // enableAutoConfig for com.contactsapp.service package
        bootstrap.addBundle(GuiceBundle.builder()
            .enableAutoConfig("com.contactsapp.service", "com.contactsapp.resources")
            .modules(new ContactsServiceModule())
            .build());
        // application initialization happens here, it includes things like regestring endpoints and getting in services
        bootstrap.addBundle(hibernate);
        // Jackson Databind feature settings can be changed this way
        bootstrap.getObjectMapper().disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
    }

    @Override
    public void run(final ContactsAppConfiguration configuration,
        final Environment environment) {
        // Register a Resource
        environment.healthChecks().register("healthcheck", new ContactsAppHealthCheck());
    }

}
