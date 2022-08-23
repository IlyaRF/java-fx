package com.example.javachatwindow.server;

import java.io.IOException;

public class Connection implements AuthService {


    public static final String DB_PATH = "src/main/resources/SqlLite.db";

    private static Connection connection;

    public static void main(String[] args) throws IOException {
        try {
            connect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void connect() {
        connection = DriverManager.getConnection("jdbc:sqlite" + DB_PATH);
    }

    @Override
    public String getNickByLoginAndPassword(String login, String password) {
       try {
           PreparedStatement stmt = connection.prepareStatement("select username from auth where login = ? and password = ?");
           stmt.setString = (1, login);
           stmt.setString = (2, password);

           ResultSet resultSet = stmt.executeQuery();

           return resultSet.getString(1);
       }catch (SQLException e) {
           System.out.println("Не удалосб получить USER NAME " + e.getMessage());
           return null;
       }
    }

    @Override
    public void close() throws IOException {

    }

    static class SQLException extends Exception {
    }

    private static class DriverManager {
        public static Connection getConnection(String s) {
            return null;
        }
    }

    public static void disconnect() throws IOException {
        if (connection != null) {
            connection.close();
        }
    }
}
