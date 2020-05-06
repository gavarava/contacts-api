package com.contactsapp.service;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.contactsapp.storage.InMemoryContactsStorage;
import org.junit.jupiter.api.Test;

public class InMemoryContactsStorageTest {

    private InMemoryContactsStorage dummyContactsService;

    @Test
    void shouldAlwaysReturnContactForDummyService() {
        dummyContactsService = new InMemoryContactsStorage();
        assertNotNull(dummyContactsService.getById(1234L));
    }


    @Test
    void shouldAlwaysReturnContactsListForDummyService() {
        dummyContactsService = new InMemoryContactsStorage();
        assertFalse(dummyContactsService.getByName("Alice").isEmpty());
    }

}