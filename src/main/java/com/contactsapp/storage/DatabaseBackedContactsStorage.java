package com.contactsapp.storage;

import com.contactsapp.model.Contact;
import java.util.List;

public class DatabaseBackedContactsStorage implements ContactsStorage {

    @Override
    public Contact getById(long id) {
        return null;
    }

    @Override
    public Contact storeContact(Contact contact) {
        return null;
    }

    @Override
    public List<Contact> getByName(String name) {
        return null;
    }
}
