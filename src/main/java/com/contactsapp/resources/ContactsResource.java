package com.contactsapp.resources;

import com.contactsapp.api.Contact;
import com.contactsapp.service.ContactsService;
import com.google.inject.Inject;
import io.dropwizard.jersey.params.LongParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ContactsResource {

    private ContactsService contactsService;

    @Inject
    public ContactsResource(ContactsService contactsService) {
        this.contactsService = contactsService;
    }

    @GET
    @Path("contacts/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Contact getContact(@PathParam("id") LongParam id) {
        return contactsService.getContact(id.get());
    }

    @POST
    @Path("contacts")
    @Produces({MediaType.APPLICATION_JSON})
    public Response createContact(Contact contact) {
        Contact createdContact = contactsService.createContact(contact);
        return Response.created(UriBuilder.fromResource(ContactsResource.class)
            .build(createdContact)).build();
    }
}
