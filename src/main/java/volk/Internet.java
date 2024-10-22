package src.main.java.volk;

public class Internet {
    public static void main(String[] args) {
        String resource = "/profile/java-developer";
        String protocol = "https://";
        String server = "practicum.yandex.ru";

        // Подставьте вместо многоточий
        // переменные в правильном порядке,
        // чтобы получился корректный URL-адрес
        String url = protocol + server + resource;

        System.out.println(url);
    }
}
