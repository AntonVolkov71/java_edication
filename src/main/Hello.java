package src.main;

import src.ru.yandex.practicum.User;

public class Hello {

    public static void main(String[] args) {
        User user = new User("Anton");
        System.out.println("name " + user.getName());
    }
}

