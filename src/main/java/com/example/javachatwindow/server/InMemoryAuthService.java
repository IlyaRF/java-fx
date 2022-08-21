package com.example.javachatwindow.server;

import java.io.IOException;
import java.util.List;

import static com.example.javachatwindow.server.Connection.JdbcApp.connect;

public class InMemoryAuthService implements AuthService {

    private static class UserData {
        private String nick;
        private String login;
        private String password;

        public UserData(String nick, String login, String password) {
            this.nick = nick;
            this.login = login;
            this.password = password;
        }

        public String getNick() {
            return nick;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }

    private List<UserData> users;

    public InMemoryAuthService() throws Connection.JdbcApp.SQLException {
        connect();
    }

    @Override
    public String getNickByLoginAndPassword(String login, String password) {
        return users.stream()
                .filter(user -> login.equals(user.getLogin())
                        && password.equals(user.getPassword()))
                .findFirst()
                .map(UserData::getNick)
                .orElse(null);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Сервис аутентификации остановлен");
    }
}