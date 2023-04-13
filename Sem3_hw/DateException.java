package Sem3_hw;

public class DateException extends Exception {
    public DateException() {
    }

    public void dataException(String i) {
        System.out.println("Exception: DateNotCorrectFormat");
        System.out.printf("It`s not correct date format: %s", i);
        System.out.println();
    }
}