package com.contactsapp.storage;

import com.contactsapp.model.Contact;
import java.util.List;

public interface ContactsStorage {

    Contact getById(long id);

    Contact storeContact(Contact contact);

    List<Contact> getByName(String name);

}
