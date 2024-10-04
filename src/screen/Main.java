package src.screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main (String[] args) throws IOException {

        // Захватываем экран
        BufferedImage screenshot = capture();

        if (screenshot != null) {
            // Обрезаем изображение (например, обрезаем центр)
//            BufferedImage croppedImage = crop(screenshot, 100, 100, 600, 400);

            // Сохраняем обрезанное изображение (добавьте код для сохранения, если нужно)
            // Например, вы можете использовать ImageIO для сохранения изображения
            ImageIO.write(screenshot, "png", new File("cropped_screenshot.png"));
        }
    }

    public static BufferedImage capture() {
        try {
            // Создаем объект Robot для захвата экрана
            Robot robot = new Robot();

            // Указываем область экрана для захвата
            Rectangle captureRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

            // Захватываем изображение
            BufferedImage screenImage = robot.createScreenCapture(captureRect);

            return screenImage;
        } catch (AWTException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static BufferedImage crop(BufferedImage image, int x, int y, int width, int height) {
        // Обрезаем изображение
        return image.getSubimage(x, y, width, height);
    }
}
