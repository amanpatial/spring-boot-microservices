package com.microservice.education.userservice;

import org.junit.ClassRule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.output.Slf4jLogConsumer;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertTrue;

public class TestContainersTest {

    private static final String MYSQL_USERNAME = "testuser";
    private static final String MYSQL_PASSWORD = "testpassword";
    private static final String MYSQL_DATABASE_NAME = "testdb";
    private static final Logger logger = LoggerFactory.getLogger(TestContainersTest.class);

    @ClassRule
    public static MySQLContainer mysqlContainer = (MySQLContainer) new MySQLContainer()
            .withUsername(MYSQL_USERNAME)
            .withPassword(MYSQL_PASSWORD)
            .withDatabaseName(MYSQL_DATABASE_NAME)
            .withLogConsumer(new Slf4jLogConsumer(logger));

    @Test
    public void testContainerMySqlConnectionIsValid() throws SQLException {

        String url = mysqlContainer.getJdbcUrl();
        String userName = mysqlContainer.getUsername();
        String password = mysqlContainer.getPassword();

        Connection connection = DriverManager.getConnection(url, userName, password);
        assertThat(true).isEqualTo(connection.isValid(5000));
    }

}
