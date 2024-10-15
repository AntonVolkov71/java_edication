package src.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesTest {
    private static final String HOME = "E:\\1. Документы\\Edication\\2. Java\\java_edication\\src\\files";

    public static void main(String[] args) {
        Path myFile = Paths.get(HOME, "test.json2");

        Path moveDir = Paths.get(HOME);
        Path targetFile = moveDir.getParent().resolve(myFile.getFileName());

        try {
            Files.copy(myFile, targetFile);
        } catch (IOException e) {
            System.out.println("err " + e);
        }
    }
}
