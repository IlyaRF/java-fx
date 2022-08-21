package com.example.javachatwindow.server;

public interface Connection {
    class JdbcApp {
        private static Connection connection;
        public static void main(String[] args) {
            try {
                connect();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }
        public static void connect() throws SQLException {
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/SqlLite.db");
        }
        public static void disconnect() {
            if (connection != null) {
                connection.close();
            }
        }

        static class SQLException extends Exception {
        }

        private static class DriverManager {
            public static Connection getConnection(String s) {
                return null;
            }
        }
    }

    void close();
}
