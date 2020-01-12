package com.contactsapp.service;

import com.contactsapp.api.Contact;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyContactsService implements ContactsService {

    private Map<String, Contact> contactsDataStore;

    public DummyContactsService() {
        this.contactsDataStore = new HashMap<>();
    }

    @Override
    public Contact getContact(long id) {
        return new Contact("Alice", "Alvsson", "24 Park Avenue", "96122", "LA", "530-322-3054");
    }

    @Override
    public Contact createContact(Contact contact) {
        return contactsDataStore.put(String.valueOf(contact.hashCode()), contact);
    }

    @Override
    public List<Contact> getContactsByName(String name) {
        return Arrays.asList(new Contact("Alice", "Alvsson", "24 Park Avenue", "96122", "LA", "530-322-3054"));
    }
}
