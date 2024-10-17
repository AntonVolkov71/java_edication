package src.files;


import java.time.LocalDateTime;
import java.util.function.Supplier;

public class FilesTest {
    public static void main(String[] args) {

        Supplier<LocalDateTime> currentDateTimeSupplier = () -> LocalDateTime.now();

        System.out.println("Текущая дата и время: " + currentDateTimeSupplier.get());
        System.out.println("Текущая дата и время: " + LocalDateTime.now());

    }
}