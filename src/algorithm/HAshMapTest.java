package src.algorithm;

public class HAshMapTest {
    public static void main(String[] args) {
        try {
            System.out.println(getPositiveInteger("10"));
            System.out.println(getPositiveInteger("abc"));
        } catch (IncorrectInputStringException e) {
            System.out.println("Необходимо ввести число");
        } catch (NumberShouldBePositiveException e) {
            System.out.println("Число должно быть положительным");
        }
    }

    public static int getPositiveInteger(final String input)
        // указываем исключения через запятую
            throws NumberShouldBePositiveException, IncorrectInputStringException {
        try {
            int value = Integer.parseInt(input);
            if (value < 0) {
                throw new NumberShouldBePositiveException();
            }
            return value;
        } catch (NumberFormatException exception) {
            throw new IncorrectInputStringException();
        }
    }
}

class NumberShouldBePositiveException extends Exception {
}

class IncorrectInputStringException extends Exception {
}