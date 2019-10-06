package com.contactsapp;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * This translates to the Dropwizard Service Configuration from ./deploymentConfiguration.yaml
 * It needs to be added with JsonProperty annotations for every custom configuration element added in the ./deploymentConfiguration.yaml
 */
public class ContactsAppConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}
