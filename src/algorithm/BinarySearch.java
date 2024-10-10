package src.algorithm;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 5, 8, 12, 13, 20, 22, 24, 30, 32};

        System.out.println("Индекс искомого элемента: " + utilsBinarySearch(array, 30));
    }

    public static int utilsBinarySearch(int[] array, int elem) {
        return Arrays.binarySearch(array, elem);
    }

    public static int findBinary(int[] array, int elem) {
        int index = -1;
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            // если элемент равен
            if (array[mid] == elem) {
                index = mid;
                break;
            } else if (array[mid] > elem) { // если искомый элемент меньше середины, то берем левую часть
                high = mid - 1;
            } else if (array[mid] < elem) { // если искомый элемент больше середины, то берем правую часть
                low = mid + 1;
            }
        }

        return index;
    }
}
