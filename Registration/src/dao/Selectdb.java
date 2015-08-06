package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Selectdb {

	private String url;
    private String username;
    private String password;

    public Selectdb(String driver, String url, String username, String password) {
        try { 
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver class is missing in classpath", e);
        }
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}

