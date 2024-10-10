package src.algorithm;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 3, 2, 9, 1, 2, 3, 4, 1, 10};

        insertionSort(array);

        for (int el : array) {
            System.out.print(el + " ");
        }
    }

    public static void insertionSort(int[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            // key — значение, которое нужно вставить в правильное место,
            // чтобы массив [0, .., i] остался отсортированным
            int key = array[i];

            // j начинает рассматривать элементы с конца отсортированной части массива
            int j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }

            /*
             * Передвигаем элементы массива [0, ..,  i - 1], которые больше ключа
             * на одну позицию вперёд относительно их текущей позиции.
             * Сначала передвигаются элементы, которые ближе к правому краю.
             */
            array[j + 1] = key;
        }

    }
}
