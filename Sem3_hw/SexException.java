package Sem3_hw;

public class SexException extends Exception {
    public SexException() {
    }

    public void sexException(String i) {
        System.out.println("Exception: SexNotCorrectData");
        System.out.printf("It`s not correct data: %s", i);
        System.out.println();
    }
}