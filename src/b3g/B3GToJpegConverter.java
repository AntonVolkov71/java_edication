package src.b3g;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class MetaInfoForm extends JFrame {
    private JTable table;
    private JButton closeButton;
    private JButton extractImageButton;

    public MetaInfoForm() {
        setTitle("Form1");
        setSize(512, 420);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Центрируем форму

        // Создание панели для размещения компонентов
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        // Создание таблицы для отображения метаинформации
        String[] columnNames = {"Name", "Value"};
        Object[][] data = {}; // Начальные данные
        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Кнопка "Extract Image"
        extractImageButton = new JButton("Extract Image");
        extractImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                extractImage();
            }
        });

        // Кнопка "Close"
        closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Закрыть форму
            }
        });

        // Панель для кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(extractImageButton);
        buttonPanel.add(closeButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);
    }

    // Метод для извлечения изображения из файла B3G
    private void extractImage() {
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
                updateMetaInfo(new String[][]{
                        {"Image", outputFilePath}
                });
            } else {
                System.out.println("Не удалось декодировать изображение.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для обновления таблицы метаинформацией
    public void updateMetaInfo(String[][] metaInfo) {
        // Предполагается, что metaInfo - это массив строк, где каждая строка содержит имя и значение
        String[] columnNames = {"Name", "Value"};
        Object[][] data = new Object[metaInfo.length][2];
        for (int i = 0; i < metaInfo.length; i++) {
            data[i][0] = metaInfo[i][0]; // Имя
            data[i][1] = metaInfo[i][1]; // Значение
        }
        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }

    private BufferedImage decodeImage(byte[] data) {
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

    public static void main(String[] args) {
        MetaInfoForm form = new MetaInfoForm();
        form.setVisible(true);
    }
}
