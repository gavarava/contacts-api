package com.contactsapp.service;

import com.contactsapp.api.Contact;
import java.util.Arrays;
import java.util.List;

public class DummyContactsService implements ContactsService {

    @Override
    public Contact getContact(long id) {
        return new Contact("Alice", "Alvsson", "24 Park Avenue", "96122", "LA", "530-322-3054");
    }

    @Override
    public List<Contact> getContactsByName(String name) {
        return Arrays.asList(new Contact("Alice", "Alvsson", "24 Park Avenue", "96122", "LA", "530-322-3054"));
    }
}
