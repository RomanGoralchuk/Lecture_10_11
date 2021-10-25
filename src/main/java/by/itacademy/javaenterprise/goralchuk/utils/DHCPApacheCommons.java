package by.itacademy.javaenterprise.goralchuk.utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.ResourceBundle;

public class DHCPApacheCommons {
    private static BasicDataSource dataSource;

    public static BasicDataSource getDataSource() {
        ResourceBundle resource = ResourceBundle.getBundle("database");
        String url = resource.getString("url");
        String user = resource.getString("user");
        String pass = resource.getString("password");

        if (dataSource == null) {
            BasicDataSource ds = new BasicDataSource();
            ds.setUrl(url);
            ds.setUsername(user);
            ds.setPassword(pass);

            ds.setMinIdle(5);
            ds.setMaxIdle(10);
            ds.setMaxOpenPreparedStatements(100);

            dataSource = ds;
        }
        return dataSource;
    }

}