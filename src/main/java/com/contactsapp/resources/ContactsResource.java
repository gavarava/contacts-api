package com.contactsapp.resources;

import com.contactsapp.api.Contact;
import com.contactsapp.service.ContactsService;
import com.google.inject.Inject;
import io.dropwizard.jersey.params.LongParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ContactsResource {

    private ContactsService contactsService;

    @Inject
    public ContactsResource(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @GET
    @Path("contact/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Contact getContact(@PathParam("id") LongParam id) {
        return contactsService.getContact(id.get());
    }
}
