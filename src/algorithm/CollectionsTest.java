package src.algorithm;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionsTest {
    public static void main(String[] args) {
        final Collection<String> strings = new ArrayList<>();

        strings.add("hello");
        strings.add("world");
        strings.add("beaches");

        System.out.println("contains " + strings.contains("hello"));
        System.out.println("size " + strings.size());

        strings.remove("beaches");

        for (Object el : strings.toArray()) {
            System.out.println(el);
        }

    }
}
