package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) throws SQLException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws SQLException {
        connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("login"),
                properties.getProperty("password")
        );
    }

    public void createTable(String tableName) {
        String sql = String.format(
                "create table if not exists %s(%s);",
                tableName,
                "id serial primary key"
        );
        executeStatement(sql);
    }

    public void dropTable(String tableName) {
        String sql = String.format(
                "drop table %s;",
                tableName
        );
        executeStatement(sql);
    }

    public void addColumn(String tableName, String columnName, String type) {
        String sql = String.format(
                "alter table %s add column %s %s;",
                tableName,
                columnName,
                type
        );
        executeStatement(sql);
    }

    public void dropColumn(String tableName, String columnName) {
        String sql = String.format(
                "alter table %s drop column %s;",
                tableName,
                columnName
        );
        executeStatement(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
        String sql = String.format(
                "alter table %s rename column %s to %s;",
                tableName,
                columnName,
                newColumnName
        );
        executeStatement(sql);
    }

    private void executeStatement(String sqlCommand) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "COLUMN", "TYPE"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("app.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        TableEditor editor = new TableEditor(prop);
        System.out.println("---Создание пустой таблицы---");
        editor.createTable("test_table");
        System.out.println(editor.getScheme("test_table"));
        System.out.println("---Добавление столбца в таблицу---");
        editor.addColumn("test_table", "name", "varchar(255)");
        System.out.println(editor.getScheme("test_table"));
        System.out.println("---Переименование столбца таблицы---");
        editor.renameColumn("test_table", "name", "rename");
        System.out.println(editor.getScheme("test_table"));
        System.out.println("---Удаление столбца таблицы---");
        editor.dropColumn("test_table", "rename");
        System.out.println(editor.getScheme("test_table"));
        System.out.println("---Удаление таблицы---");
        editor.dropTable("test_table");
        System.out.println(editor.getScheme("test_table"));
    }
}