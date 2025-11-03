package com.example;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DbConnectionTest {

    @Test
    void canConnectToMysql() throws Exception {
        String url = "jdbc:mysql://localhost:3306/unittest";
        String user = "root";
        String pass = ""; // we allowed empty password in GitHub Actions

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT 1")) {

            if (rs.next()) {
                int v = rs.getInt(1);
                assertEquals(1, v);
            }
        }
    }
}
