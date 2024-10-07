package src.screen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

class Person {
    public String firstName;
    public String lastName;
    public String[] pays;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pays=" + Arrays.toString(pays) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Arrays.equals(pays, person.pays);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(firstName, lastName);
        result = 31 * result + Arrays.hashCode(pays);
        return result;
    }
}

public class Main {

    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>(); // список имён и фамилий
        HashMap<Person, String> contacts = new HashMap<>(); // хеш-таблица контактов

        String firstName = "Стив";
        String lastName = "Джобс";
        String phoneNumber = "8 (988) 123-45-67";

        persons.add(new Person(firstName, lastName)); // добавляем элемент в список

        contacts.put(new Person(firstName, lastName), phoneNumber); // добавляем элемент в таблицу

        System.out.println("Количество людей в списке: " + persons.size() + ", контактов: " + contacts.size()); // проверяем наличие элементов

        if (persons.contains(new Person(firstName, lastName))) { // ищем элемент в списке
            System.out.println("Человек с именем " + firstName + " и фамилией " + lastName + " найден в списке.");
        } else {
            System.out.println("Метод equals у класса Person реализован неверно!");
        }

        // ищем элемент в таблице по ключу:
        if (contacts.containsKey(new Person(firstName, lastName))) {
            System.out.println("Человек с именем " + firstName + " и фамилией " + lastName + " найден в таблице контактов. Его телефонный номер: " + contacts.get(new Person(firstName, lastName)));
        } else {
            System.out.println("Метод hashCode у класса Person реализован неверно!");
        }

        System.out.println(new Person(firstName, lastName));
    }
}
