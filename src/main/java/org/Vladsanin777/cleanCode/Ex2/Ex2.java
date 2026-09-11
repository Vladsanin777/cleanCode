package org.Vladsanin777.cleanCode.Ex2;

import java.time.LocalDate;

class Ex2 {
    public static void main(String[] args) {
        User user = new User(101L, "vlad_sanin", "abc123hash", "eyJhbGciOiJIUzI1Ni...");

        System.out.println("ID пользователя: " + user.getId());
        System.out.println("Логин: " + user.getLogin());

        if (user.isAuthorized()) {
            System.out.println("User successfull autoriseded.");
        } else {
            System.out.println("User faild autoriseded.");
        }

        System.out.println("Tomorrow data: " + User.tomorrow());

        user.send(5L, 2026L); 

        System.out.println("Counter sending messages: " + user.getSendingMessages());
    }
}
