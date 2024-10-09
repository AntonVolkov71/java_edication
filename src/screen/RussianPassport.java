package src.screen;

public class RussianPassport<T> implements Document<T> {

    private T value;

    public RussianPassport(T value) {
        this.value = value;
    }

    @Override
    public T getDocumentNumber() {
        return value;
    }

}
