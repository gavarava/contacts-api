package com.contactsapp.storage;

import java.util.UUID;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

public interface ContactsDAO {

    @SqlUpdate("INSERT INTO contact_details (contact_id, firstName, lastname, address, postcode, city, phonenumber) VALUES (:contact_id, :firstName, :lastname, :address, :postcode, :city, :phonenumber)")
    void insertContact(@Bind("contact_id") UUID contactId, @Bind("firstName") String firstName,
        @Bind("lastname") String lastname, @Bind("postcode") String postcode, @Bind("city") String city,
        @Bind("phonenumber") String phonenumber);

    @SqlQuery("SELECT * FROM contact_details WHERE contact_id = :contact_id")
    void findById(@Bind("contact_id") String contactId);

    @SqlQuery("SELECT * FROM contact_details WHERE firstName = :firstName OR lastname = :lastname")
    void findByName(@Bind("firstName") String firstName, @Bind("lastname") String lastname);

}
