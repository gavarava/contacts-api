package com.contacts.api.app;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class ContactsApp extends Application<ContactsAppConfiguration> {

  public static void main(String[] args) throws Exception {
    new ContactsApp().run(args);
  }

  @Override
  public void run(ContactsAppConfiguration contactsAppConfiguration, Environment environment)
      throws Exception {

  }
}
