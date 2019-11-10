package com.contactsapp.providers;

import com.contactsapp.service.DatabaseConnectionService;
import com.google.inject.Inject;
import com.google.inject.Provider;
import io.dropwizard.db.DataSourceFactory;

public class DatabaseConnectionServiceProvider implements
    Provider<DatabaseConnectionService> {

    private DataSourceFactory dataSourceFactory;

    @Inject
    public DatabaseConnectionServiceProvider(DataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }

    @Override
    public DatabaseConnectionService get() {
        // Different Implementations of the the service can be provided here
        return new DatabaseConnectionService(dataSourceFactory);

    }
}
