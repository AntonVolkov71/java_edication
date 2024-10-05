package src.screen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<String> names = new ArrayList<String>();

        names.add("anton");
        names.add("Inna");
        names.add(0, "Diana");
        names.add("dog");
        names.add("cat");

        names.remove(3);
        names.remove("cat");

        HashMap<String, Integer> ages = new HashMap<String, Integer>();

        ages.put("anton", 34);
        ages.put("inna", 36);
        ages.put("diana", 8);

        for (Map.Entry<String, Integer> ent : ages.entrySet()) {
            System.out.println(ent);

        }

        for (String name : names) {
            System.out.println(name);
        }

    }
}
