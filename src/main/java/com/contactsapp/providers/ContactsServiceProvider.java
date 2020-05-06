package com.contactsapp.providers;

import com.contactsapp.storage.ContactsStorage;
import com.contactsapp.storage.InMemoryContactsStorage;
import com.google.inject.Provider;

public class ContactsServiceProvider implements
    Provider<ContactsStorage> {

    @Override
    public ContactsStorage get() {
        // The DI Framework is deciding what Implementation to choose for the ContactsStorage
        // Is it possible to configure the implementation to be picked by giving a profile ?
        return new InMemoryContactsStorage();
    }
}
