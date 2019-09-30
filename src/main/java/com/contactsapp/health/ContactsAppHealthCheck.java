package com.contactsapp.health;

import ru.vyarus.dropwizard.guice.module.installer.feature.health.NamedHealthCheck;

public class ContactsAppHealthCheck extends NamedHealthCheck {

    @Override
    public String getName() {
        return "Contacts Application";
    }

    @Override
    protected Result check() {
        return Result.healthy("Service is up and running");
    }
}
