package src.main.java.volk.httpServer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HttpServerTest {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create();

        httpServer.bind(new InetSocketAddress(9999), 0);
        httpServer.createContext("/hello", new HelloHandler());

        UserPost post = new UserPost();
        post.setPhotoUrl("https://new-social-network.site/images/928476864.jpg");
        post.setUserId(97_748);
        post.setDescription("Классное фото!");
        post.setLikesQuantity(753);

        // сконвертируйте publicationDateString в экземпляр LocalDate
        String publicationDateString = "25--12--2020";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd--MM--yyyy");

        LocalDate publicationDate = LocalDate.from(LocalDate.parse(publicationDateString, formatter));
        post.setPublicationDate(publicationDate);
        // создайте экземпляр Gson
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();

        // сериализуйте объект
        String postSerialized = gson.toJson(post);
        System.out.println("Serialized post: " + postSerialized);

        // десериализуйте объект
        UserPost postDeserialized = gson.fromJson(postSerialized, UserPost.class);
        System.out.println("Deserialized post: " + postDeserialized.getDescription());
        httpServer.start();
    }
}
