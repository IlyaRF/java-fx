package com.example.javachatwindow.server;

import java.io.IOException;
import java.sql.*;

public class Connection implements AuthService {


    public static final String DB_PATH = "src/main/resources/SqlLite.db";
    private static java.sql.Connection connection;

    public Connection() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
        } catch (SQLException e) {
            throw new RuntimeException("Не удалось подключиться к базе " + e.getMessage(), e);
        }
    }

    @Override
    public String getNickByLoginAndPassword(String login, String password) {
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from Contacts where Login = ? and Password = ?");
            stmt.setString(1, login);
            stmt.setString(2, password);

            ResultSet resultSet = stmt.executeQuery();

            return resultSet.getString(1);
        } catch (SQLException e) {
            System.out.println("Не удалось получить USER NAME " + e.getMessage());
            return null;
        }
    }

    public static void disconnect() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void close() throws IOException {

    }
}
