package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("app.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(
                prop.getProperty("url"),
                prop.getProperty("login"),
                prop.getProperty("password"))) {
                    DatabaseMetaData metaData = connection.getMetaData();
                    System.out.println(metaData.getUserName());
                    System.out.println(metaData.getURL());
        }
    }
}
