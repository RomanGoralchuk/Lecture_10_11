package by.itacademy.javaenterprise.goralchuk.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.sql.SQLSyntaxErrorException;
import java.util.ResourceBundle;

public class ConnectionToDataBase {
    private static final Logger logger = LoggerFactory.getLogger(ConnectionToDataBase.class);

    public Connection getNewConnection() {
        String url = "jdbc:mariadb://127.0.0.1:10000/hospital";
        String userName = "root";
        String userPass = "root";
        try {
            Connection connection = DriverManager.getConnection(url, userName, userPass);
            if (connection != null) {
                logger.info("Successful connection to DB");
                return connection;
            } else {
                logger.info("Failed connection to DB");
            }
        } catch (SQLInvalidAuthorizationSpecException e) {
            logger.error("User data is not correct", e);
        } catch (SQLSyntaxErrorException e) {
            logger.error("Could not connect to address" + url, e);
        } catch (SQLException e) {
            logger.error("Found problem" + e);
        }
        return null;
    }

    public Connection getNewConnectionViaFile() {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("url");
        String user = resource.getString("user");
        String pass = resource.getString("password");

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            if (connection != null) {
                logger.info("Successful connection to DB");
                return connection;
            } else {
                logger.info("Failed connection to DB");
            }
        } catch (SQLInvalidAuthorizationSpecException e) {
            logger.error("User data is not correct", e);
        } catch (SQLSyntaxErrorException e) {
            logger.error("Could not connect to address" + url, e);
        } catch (SQLException e) {
            logger.error("Found problem" + e);
        }
        return null;
    }
}
