package com.contactsapp.providers;

import com.contactsapp.service.ContactsService;
import com.contactsapp.service.DummyContactsService;
import com.google.inject.Provider;

public class ContactsServiceProvider implements
    Provider<ContactsService> {

    @Override
    public ContactsService get() {
        // The DI Framework is deciding what Implementation to choose for the ContactsService
        // Is it possible to configure the implementation to be picked by giving a profile ?
        return new DummyContactsService();
    }
}
