package com.contactsapp.modules;

import com.contactsapp.ContactsAppConfiguration;
import com.contactsapp.providers.ContactsServiceProvider;
import com.contactsapp.storage.ContactsStorage;
import javax.inject.Singleton;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

public class ContactsServiceModule extends DropwizardAwareModule<ContactsAppConfiguration> {

    @Override
    protected void configure() {
        bind(ContactsStorage.class).toProvider(ContactsServiceProvider.class).in(Singleton.class);
    }

}
