package src;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args) {
        // Допишите тип для names
        String[] names = {"Маша", "Саша", "Катя", "Артём"};
        sayHello(names);

        // Укажите тип переменной
        int sum = add(3, 6);
    }

    // Добавьте подходящий тип у параметра метода
    public static void sayHello(String[] names) {
        // У переменной итерирования тоже должен быть тип
        for (int i = 0; i < names.length; i++) {
            System.out.println("Привет, " + names[i]);
        }
    }

    // Вставьте тип возвращаемого значения метода и его параметров
    public static int add(int a, int b) {
        return a + b;
    }
}
