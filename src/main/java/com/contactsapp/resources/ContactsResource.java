package com.contactsapp.resources;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import com.contactsapp.api.Contact;
import com.contactsapp.storage.ContactsStorage;
import com.google.inject.Inject;
import io.dropwizard.jersey.params.LongParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/contacts")
@Produces(APPLICATION_JSON)
public class ContactsResource {

    private ContactsStorage contactsStorage;

    @Inject
    public ContactsResource(ContactsStorage contactsStorage) {
        this.contactsStorage = contactsStorage;
    }

    @GET
    @Path("contact/{id}")
    @Produces({APPLICATION_JSON})
    public Contact getContact(@PathParam("id") LongParam id) {
        com.contactsapp.model.Contact contact = contactsStorage.getById(id.get());

        return new com.contactsapp.api.Contact(contact.getFirstName(),
            contact.getLastName(), contact.getAddress(), contact.getPostCode(), contact.getCity(),
            contact.getPhoneNumber());
    }

    @POST
    @Path("contact")
    @Consumes(APPLICATION_JSON)
    @Produces({APPLICATION_JSON})
    public Response createContact(Contact contact) {
        // Translation from DTO to a Domain Model Object
        com.contactsapp.model.Contact newContact = new com.contactsapp.model.Contact(contact.getFirstName(),
            contact.getLastName(), contact.getAddress(), contact.getPostCode(), contact.getCity(),
            contact.getPhoneNumber());

        com.contactsapp.model.Contact createdContact = contactsStorage.storeContact(newContact);

        // Translation from Domain Model Object to a DTO
        Contact storedContact = new Contact(createdContact.getFirstName(),
            createdContact.getLastName(), createdContact.getAddress(), createdContact.getPostCode(),
            createdContact.getCity(),
            createdContact.getPhoneNumber());

        return Response.created(UriBuilder.fromResource(ContactsResource.class)
            .build(storedContact)).build();
    }
}
