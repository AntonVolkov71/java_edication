package src.main.java.volk.httpServer;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServerTest {
    public static void main(String[] args) throws IOException {
        HttpServer httpServer = HttpServer.create();

        httpServer.bind(new InetSocketAddress(9999), 0);
        httpServer.createContext("/hello", new HelloHandler());

        httpServer.start();
    }
}
