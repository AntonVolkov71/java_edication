package src.screen;

public class Main {

    public static void main(String[] args) {
// Java автоматически привела объект класса RussianPassport к типу интерфейса Document
        Document<String> document = new RussianPassport<>("hhh");

        System.out.println(document.getDocumentNumber());
//        System.out.println(document instanceof RussianPassport);
    }
}
