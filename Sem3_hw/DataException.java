package Sem3_hw;

public class DataException extends Exception{
    public DataException() {
    }

    public void dataException(String i) {
        System.out.println("Exception: DataNotCorrectFormat");
        System.out.printf("It`s not correct format: %s", i);
        System.out.println();
    }
}