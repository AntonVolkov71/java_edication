package src.b3g;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class B3GToJpegConverter {
    public static void main(String[] args) {
        String inputFilePath = "E:\\1. Документы\\Edication\\2. Java\\java_edication\\public_files\\test.b3g"; // Указан путь к вашему B3G файлу
        String outputFilePath = "output/image.jpeg"; // Укажите путь для сохранения JPEG

        try {
            // Чтение файла B3G
            FileInputStream fis = new FileInputStream(inputFilePath);
            byte[] data = new byte[fis.available()];
            fis.read(data);
            fis.close();

            // Преобразование байтового массива в BufferedImage
            BufferedImage image = decodeImage(data);

            // Проверка, было ли изображение успешно декодировано
            if (image != null) {
                // Сохранение изображения в формате JPEG
                ImageIO.write(image, "jpeg", new File(outputFilePath));
                System.out.println("Изображение успешно сохранено в формате JPEG: " + outputFilePath);
            } else {
                System.out.println("Не удалось декодировать изображение.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage decodeImage(byte[] data) {
        // Известные размеры изображения
        int width = 561;
        int height = 834;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // Предположим, что после заголовка данных идет RGB (без дополнительных байтов)
        int offset = 0; // Здесь можно указать размер заголовка, если он есть

        // Заполнение изображения
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Расчет индекса с учетом смещения
                int index = offset + (y * width + x) * 3; // RGB: 3 байта на пиксель
                if (index + 2 < data.length) { // Проверка на выход за границы массива
                    int r = data[index] & 0xFF;     // Красный
                    int g = data[index + 1] & 0xFF; // Зеленый
                    int b = data[index + 2] & 0xFF; // Синий

                    // Установка цвета пикселя
                    int rgb = (r << 16) | (g << 8) | b; // Создание RGB цвета
                    image.setRGB(x, y, rgb);
                }
            }
        }

        return image;
    }



}
