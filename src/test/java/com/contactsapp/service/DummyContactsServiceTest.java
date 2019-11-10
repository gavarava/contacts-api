package com.contactsapp.service;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class DummyContactsServiceTest {

    private DummyContactsService dummyContactsService;

    @Test
    void shouldAlwaysReturnContactForDummyService() {
        dummyContactsService = new DummyContactsService();
        assertNotNull(dummyContactsService.getContact(1234L));
    }


    @Test
    void shouldAlwaysReturnContactsListForDummyService() {
        dummyContactsService = new DummyContactsService();
        assertFalse(dummyContactsService.getContactsByName("Alice").isEmpty());
    }

}