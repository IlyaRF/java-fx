package com.example.javachatwindow.server;

import java.io.IOException;
import java.util.List;

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