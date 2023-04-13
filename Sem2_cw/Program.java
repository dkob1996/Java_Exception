package Sem2_cw;

import javax.imageio.IIOException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Program {


    private static Random random = new Random();

    /**
     1.  Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
     При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
     2.  Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
     Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа),
     должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
     3.  В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и
     MyArrayDataException и вывести результат расчета.
    */
    public static void main(String[] args){
        //generateArray();

        //try
        //catch
        //finally

        /*try {
            task1();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }*/

        for (int i = 0; i < 10; i++){
            System.out.printf("\n *** Итерация %d *** \n\n", i + 1);

            processArray();
        }


    }

    static void task1() throws Exception{
        task2();
    }

    static void task2() throws Exception{
        task3();
    }

    static void task3() throws Exception{
        task4();
    }

    static void task4() throws Exception{
        throw new Exception("Произошло исключение!");
    }


    public static void processArray(){

        int sum = 0;


        FileReader reader = null;
        try
        {
            reader = new FileReader("C:/test.txt");
            sum = processArrayInternal(generateArray());
            System.out.printf("Сумма всех элементов массива: %d\n", sum);
        }
        catch (MyArraySizeException e){
            System.out.printf("%s\nТребовалось 4x4, получили %dx%d\n", e.getMessage(), e.getX(), e.getY());

        }

        catch (MyArrayDataException e){
            System.out.printf("%s\nКоординаты элемента [%d][%d]\n", e.getMessage(), e.getX(), e.getY());

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Завершение обработки массива ...");
            System.out.println(sum);
            if (reader != null)
                try {
                    reader.close();
                }
                catch (IOException e){

                }
        }

    }




    public static String[][] generateArray(){
        int add = random.nextInt(2); // 0 - 1
        String[][] arr = new String[4 + add][4 + add];

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (random.nextInt(50) < 2) {
                    arr[i][j] = "abc";
                }
                else{
                    arr[i][j] = Integer.toString(random.nextInt(100));
                }
                System.out.printf("%s ", arr[i][j]);
            }
            System.out.println();
        }
        return arr;
    }

    /**
     * Метод обработки массива
     * @param arr массив
     * @return сумма всех элементов массива
     * @throws MyArraySizeException некорректный размер массива
     * @throws MyArrayDataException некорректный формат данных
     */
    static int processArrayInternal(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        int a = 10 / random.nextInt(5);

        if (arr.length != 4 || arr[0].length != 4)
            throw new MyArraySizeException("Некорректный размер массива.", arr.length, arr[0].length );

        int sum = 0;

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                sum += parseElement(arr[i][j], i, j);
            }
        }
        return sum;
    }

    /**
     * Вспомогательный метод, преобразование значения элемента к числу
     * @param element значение элемента массива для анализа
     * @param i индекс элемента массива
     * @param j индекс элемента массива
     * @return результат преобразования элемента к числу
     * @throws MyArrayDataException некорректный формат данных
     */
    static int parseElement(String element, int i, int j) throws MyArrayDataException{

        try {
            return Integer.parseInt(element);
        }
        catch (NumberFormatException e){
            throw new MyArrayDataException("Некорректный формат данных", i, j);
        }
    }

}
abstract class MyException extends Exception{

    private final int x;
    private final int y;

    public MyException(String message, int x, int y){
        super(message);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

class MyArraySizeException extends MyException{

    public MyArraySizeException(String message, int x, int y){
        super(message, x, y);
    }

}

class MyArrayDataException extends MyException{

    public MyArrayDataException(String message, int x, int y){
        super(message, x, y);
    }

}