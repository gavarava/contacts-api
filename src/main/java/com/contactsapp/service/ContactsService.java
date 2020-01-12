package com.contactsapp.service;

import com.contactsapp.api.Contact;
import java.util.List;

public interface ContactsService {

    Contact getContact(long id);

    Contact createContact(Contact contact);

    List<Contact> getContactsByName(String name);

}
