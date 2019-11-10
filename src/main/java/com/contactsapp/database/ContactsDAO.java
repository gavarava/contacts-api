package com.contactsapp.database;

import com.contactsapp.database.entities.Contact;
import io.dropwizard.hibernate.AbstractDAO;
import java.util.List;
import org.hibernate.SessionFactory;

public class ContactsDAO extends AbstractDAO<Contact> {

    public ContactsDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Contact findById(Long id) {
        return get(id);
    }

    public long create(Contact contact) {
        return persist(contact).getId();
    }

    public List<Contact> findAll() {
        return list(namedQuery("com.contactsapp.database.entities.Contact.findAll"));
    }
}
