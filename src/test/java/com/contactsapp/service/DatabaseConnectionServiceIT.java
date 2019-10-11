package com.contactsapp.service;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.contactsapp.ContactsAppConfiguration;
import com.contactsapp.ContactsApplication;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.testing.DropwizardTestSupport;
import io.dropwizard.testing.ResourceHelpers;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseConnectionServiceIT {

    private static final String DEPLOYMENT_CONFIGURATION = "testDeploymentConfiguration.yaml";
    private static final DropwizardTestSupport<ContactsAppConfiguration> CONTACTS_APP_FOR_TEST = new DropwizardTestSupport<>(
        ContactsApplication.class,
        ResourceHelpers.resourceFilePath(DEPLOYMENT_CONFIGURATION));
    private static final String CREATE_TABLE_SQL = "/createTable.sql";

    private DatabaseConnectionService target;
    private ContactsAppConfiguration configuration;

    @BeforeEach
    void setup() {
        CONTACTS_APP_FOR_TEST.before();
        configuration = CONTACTS_APP_FOR_TEST.getConfiguration();
    }

    @Test
    void shouldInitializeConnectionSuccessfully() throws SQLException, IllegalAccessException {
        // Given
        target = new DatabaseConnectionService(configuration.getDataSourceFactory());
        // When
        try {
            target.initializeConnection();
        } catch (SQLException | ClassNotFoundException e) {
            fail("Exception: " + e.getMessage());
        }
        // Then
        assertNotNull(target.getConnection());
        target.closeConnection();
    }

    @Test
    void shouldThrowExceptionWhenNotAbleToConnectToDatabase() {
        // Given
        DataSourceFactory dataSourceFactoryFromConfiguration = configuration.getDataSourceFactory();
        dataSourceFactoryFromConfiguration.setUrl("");
        target = new DatabaseConnectionService(dataSourceFactoryFromConfiguration);
        // When
        assertThrows(SQLException.class, () -> target.initializeConnection());
    }

    @Test
    void shouldCreateTableOnDatabaseStartup() throws IllegalAccessException {
        DataSourceFactory dataSourceFactoryFromConfiguration = configuration.getDataSourceFactory();
        String defaultDatasourceUrlFromConfigurationYaml = dataSourceFactoryFromConfiguration.getUrl();
        dataSourceFactoryFromConfiguration
            .setUrl(defaultDatasourceUrlFromConfigurationYaml + ";INIT=RUNSCRIPT FROM '" + getClass()
                .getResource(CREATE_TABLE_SQL).getPath() + "'");
        target = new DatabaseConnectionService(dataSourceFactoryFromConfiguration);
        try {
            target.initializeConnection();
            Connection connection = target.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts_info");
            assertThat(resultSet.next(), is(false));
        } catch (SQLException | ClassNotFoundException e) {
            fail(e.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
        CONTACTS_APP_FOR_TEST.after();
    }
}
