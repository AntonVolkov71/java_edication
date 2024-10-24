package src.main.java.volk;

public class Main {
    public static void main(String[] args) {
        Main calculator = new Main();
        System.out.println(calculator.sumAfterDiscount(2222));
    }

    public int sumAfterDiscount(int sum) {
        if (sum < 1000) {
            return sum;
        } else {
            return (int) (sum * 0.98);
        }
    }
}
