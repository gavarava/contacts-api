package com.contactsapp.modules;

import com.contactsapp.ContactsAppConfiguration;
import com.contactsapp.providers.DatabaseConnectionServiceProvider;
import com.contactsapp.service.DatabaseConnectionService;
import javax.inject.Singleton;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

public class DatabaseConnectionServiceModule extends DropwizardAwareModule<ContactsAppConfiguration> {

    @Override
    protected void configure() {
        bind(DatabaseConnectionService.class).toProvider(DatabaseConnectionServiceProvider.class).in(Singleton.class);
    }
}
