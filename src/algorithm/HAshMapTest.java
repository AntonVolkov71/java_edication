package src.algorithm;

import java.util.HashMap;
import java.util.Map;

public class HAshMapTest {
    public static void main(String[] args) {
        Map<String, String> countriesAndContinents = new HashMap<>();

        countriesAndContinents.put("Марокко", "Африка");
        countriesAndContinents.put("Танзания", "Африка");

        for (Map.Entry<String, String> el : countriesAndContinents.entrySet()) {
            System.out.println(el.getKey());
            System.out.println(el.getValue());
        }
    }
}
