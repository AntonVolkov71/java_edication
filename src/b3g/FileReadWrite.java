package src.b3g;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileReadWrite {
    public static void main(String[] args) {
        String inputFilePath = "E:\\1. Документы\\Edication\\2. Java\\java_edication\\public_files\\test.b3g"; // Указан путь к вашему B3G файлу
        String outputFilePath = "output/image.bin"; // Указан путь для сохранения выходного файла

        try (FileInputStream fis = new FileInputStream(inputFilePath);
             FileOutputStream fos = new FileOutputStream(outputFilePath)) {
            byte[] buffer = new byte[4096]; // Размер буфера для чтения
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                // Преобразование прочитанных байтов в шестнадцатеричный формат и запись в выходной файл
                for (int i = 0; i < bytesRead; i++) {
                    String hex = String.format("%02X ", buffer[i]); // Преобразование в шестнадцатеричный формат
                    fos.write(hex.getBytes()); // Запись в выходной файл
                }
            }
            System.out.println("Данные успешно сохранены в файл: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
