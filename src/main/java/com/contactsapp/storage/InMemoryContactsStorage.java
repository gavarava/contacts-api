package com.contactsapp.storage;

import com.contactsapp.model.Contact;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryContactsStorage implements ContactsStorage {

    private Map<String, Contact> contactsDataStore;

    public InMemoryContactsStorage() {
        this.contactsDataStore = new HashMap<>();
    }

    @Override
    public Contact getById(long id) {
        return new Contact("Alice", "Alvsson", "24 Park Avenue", "96122", "LA", "530-322-3054");
    }

    @Override
    public Contact storeContact(Contact contact) {
        return contactsDataStore.put(String.valueOf(contact.hashCode()), contact);
    }

    @Override
    public List<Contact> getByName(String name) {
        return Arrays.asList(new Contact("Alice", "Alvsson", "24 Park Avenue", "96122", "LA", "530-322-3054"));
    }
}
