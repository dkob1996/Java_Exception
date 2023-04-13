package Sem1_cw;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Program {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        //System.out.printf("Длина массива: %d\n", task1(new int[] {1, 2, 3}));
        //task2();
        //task3();
        //task4();
        task5();
    }

    /**
     Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
     Если длина массива меньше некоторого заданного минимума, метод возвращает
     -1, в качестве кода ошибки, иначе - длину массива.
     */
    static int task1(int[] arr){
        if (arr == null)
            return -2;
        if (arr.length == 0)
            return -1;
        return arr.length;
    }

    /**
     Реализуйте метод, принимающий в качестве аргумента целочисленный массив и некоторое значение.
     Метод ищет в массиве заданное значение и возвращает его индекс. При этом, например:
     1. если длина массива меньше некоторого заданного минимума, метод возвращает -1, в качестве кода ошибки.
     2. если искомый элемент не найден, метод вернет -2 в качестве кода ошибки.
     3. если вместо массива пришел null, метод вернет -3
     4. придумайте свои варианты исключительных ситуаций и верните соответствующие коды ошибок.
     Напишите метод, в котором реализуйте взаимодействие с пользователем.
     То есть, этот метод запросит искомое число у пользователя, вызовет первый,
     обработает возвращенное значение и покажет читаемый результат пользователю.
     Например, если вернулся -2, пользователю выведется сообщение: “Искомый элемент не найден”.
     */

    static void task2(){


        while (true){
            System.out.print("Укажите значение для поиска: ");
            if (scanner.hasNextInt()){
                int searchNumber = scanner.nextInt();
                int[] array = new int[random.nextInt(5) + 1];
                if (random.nextInt(3) == 0)
                    array = null;
                if (array != null){
                    for (int i = 0; i < array.length; i++){
                        array[i] = random.nextInt(10);
                        System.out.printf("%d\t", array[i]);
                    }
                    System.out.println();
                }

                int codeResult = processArray(array, searchNumber);
                switch (codeResult){
                    case -1 -> System.out.println("Длина массива менее трех символов.");
                    case -2 -> System.out.println("Элемент не найден.");
                    case -3 -> System.out.println("Массив некорректно проинициализирован.");
                    default -> {
                        System.out.println("Массив успешно обработан. Завершение работы приложения.");
                        System.out.printf("Элемент найден по индексу: %d\n", codeResult);
                        return;
                    }
                }

            }
            else{
                System.out.println("Число для поиска указано некорректно.\nПовторите попытку ввода.");
                scanner.nextLine();
            }
        }

    }

    static int processArray(int[] arr, int searchArray){
        if (arr == null)
            return -3; // Массив некорректно проинициализирован
        if (arr.length < 3)
            return -1; // Длина массива менее трех символов
        Arrays.sort(arr);
        for (int e: arr){
            System.out.printf("%d\t", e);
        }
        System.out.println();
        int searchResult = Arrays.binarySearch(arr, searchArray);
        if (searchResult < 0)
            return -2; // Элемент не найден

        return searchResult;
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
     *     Необходимо посчитать и вернуть сумму элементов этого массива.
     *     При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами
     *     (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
     *     Если нарушается одно из условий, метод должен бросить RuntimeException с сообщением об ошибке.
     */

    static void task3(){
        for (int i = 0; i < 5; i++){
            processArray(generateArray());
        }
    }

    static void processArray(int[][] arr){
        for (int i = 0; i < arr.length; i++)
            if (arr[i].length != arr.length)
                throw new RuntimeException("Некорректная размерность массива.");
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                if (arr[i][j] != 0 && arr[i][j] != 1)
                    throw new RuntimeException(String.format("Некорректное значение элемента массива по индексу [%d][%d]", i, j));
                else
                    sum += arr[i][j];

        System.out.printf("Сумма элементов массива: %d\n", sum);
    }

    /**
     * Метод генерации двумерного массива чисел
     * @return Двумерный массив
     */
    static int[][] generateArray(){
        int[][] arr = new int[random.nextInt(4, 6)][5];
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++)
            {
                arr[i][j] = random.nextInt(2);
                if (random.nextInt(50) == 0)
                    arr[i][j] = 2; // Намеренная ошибка
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
        return arr;
    }

    /**
     Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный массив.
     Необходимо посчитать и вернуть сумму элементов этого массива.
     При этом накладываем на метод 2 ограничения: метод может работать только с квадратными массивами
     (кол-во строк = кол-ву столбцов), и в каждой ячейке может лежать только значение 0 или 1.
     Если нарушается одно из условий, метод должен вернуть код ошибки.
     Программа должна корректно обработать код ошибки и вывести соответствующее сообщение пользователю.
     Сравнить такой вариант обработки исключений с предыдущим.
     */

    static void task4(){
        for (int i = 0; i < 5; i++) {
            int errCode = processArrayV2(generateArray());
            switch (errCode){
                case -1 -> System.out.println("Некорректный размер массива.");
                case -2 -> System.out.println("Некорректное значение массива.");
                default -> {
                    System.out.printf("Сумма элементов массива: %d\n", errCode);
                }
            }
        }
    }

    static int processArrayV2(int[][] arr){
        for (int i = 0; i < arr.length; i++)
            if (arr[i].length != arr.length)
                return -1;
                //throw new RuntimeException("Некорректная размерность массива.");
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                if (arr[i][j] != 0 && arr[i][j] != 1)
                    return -2;
                    //throw new RuntimeException(String.format("Некорректное значение элемента массива по индексу [%d][%d]", i, j));
                else
                    sum += arr[i][j];

        //System.out.printf("Сумма элементов массива: %d\n", sum);
        return sum;
    }

    /**
    Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
     и возвращающий новый массив, каждый элемент которого равен сумме элементов двух
     входящих массивов в той же ячейке.
     Если длины массивов не равны, необходимо как-то оповестить пользователя.
    */

    static void task5(){

        try {
            int[] res = getSumArray(new int[]{1, -2, 3, 0}, new int[] {4, 3, 1, 0, 1});
            for (int e: res) {
                System.out.printf("%d\t", e);
            }
            System.out.println();
        }
        catch (CustomArraySizeException e){
            System.out.println(e.getMessage());
            System.out.printf("Длина первого массива: %d\nДлина второго массива: %d\n",
                    e.getLength1(), e.getLength2());
        }

    }

    static int[] getSumArray(int[] arr1, int[] arr2){
        if (arr1 == null || arr2 == null)
            throw new NullPointerException("Оба массива должны существовать.");
        if (arr1.length != arr2.length)
            throw new CustomArraySizeException("Кол-во элементов массива должно быть одинаковым.", arr1.length, arr2.length);

        int[] res = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++)
            res[i] = arr1[i] + arr2[i];
        return res;
    }

}

class CustomArraySizeException extends RuntimeException{

    private int length1;
    private int length2;

    public int getLength1() {
        return length1;
    }

    public int getLength2() {
        return length2;
    }

    public CustomArraySizeException(String message, int length1, int length2) {
        super(message);
        this.length1 = length1;
        this.length2 = length2;
    }
}
