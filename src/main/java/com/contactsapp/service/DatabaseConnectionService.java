package com.contactsapp.service;

import com.google.inject.Inject;
import io.dropwizard.db.DataSourceFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseConnectionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConnectionService.class);

    private DataSourceFactory dataSourceFactory;
    private Connection connection;

    @Inject
    public DatabaseConnectionService(DataSourceFactory dataSourceFactory) {
        this.dataSourceFactory = dataSourceFactory;
    }

    public void initializeConnection() throws ClassNotFoundException, SQLException {
        Class.forName(dataSourceFactory.getDriverClass());
        String databaseUrl = dataSourceFactory.getUrl();
        String user = dataSourceFactory.getUser();
        LOGGER.debug("DB Url: {}", databaseUrl);
        LOGGER.debug("DB User: {}", user);
        this.connection = DriverManager
            .getConnection(databaseUrl, user, dataSourceFactory.getPassword());
    }

    public Connection getConnection() throws IllegalAccessException {
        if (connection == null) {
            throw new IllegalAccessException("Connection not initialized");
        }
        return this.connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            this.connection.close();
        }
    }
}
