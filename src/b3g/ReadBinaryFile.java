package src.b3g;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadBinaryFile {
    public static void main(String[] args) {

        String inputFilePath = "E:\\1. Документы\\Edication\\2. Java\\java_edication\\public_files\\test.b3g"; // Указан путь к вашему B3G файлу
        String outputFilePath = "output/image.jpeg"; // Укажите путь для сохранения JPEG
        try (FileInputStream fis = new FileInputStream(inputFilePath)) {
            byte[] data = new byte[5000]; // Читаем первые 64 байта
            int bytesRead = fis.read(data);

            System.out.println("Первые " + bytesRead + " байтов:");
            for (int i = 0; i < bytesRead; i++) {
                System.out.printf("%02X ", data[i]);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
