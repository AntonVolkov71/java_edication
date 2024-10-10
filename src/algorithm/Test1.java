package src.algorithm;

public class Test1 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 3, 2, 9, 1, 2, 3, 4, 1, 10};

        int min = getMin(array);

        System.out.println(min);
    }

    static int getMin(int[] array) {
        int min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }

        return min;
    }
}
