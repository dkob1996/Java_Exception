package Sem3_hw;


import java.io.IOException;
import java.util.HashMap;
// Происходит запуск приложения
public class Program {
    public static void main(String[] args) {
        ParsData parsData = new ParsData(); // Создается объект класса ParsData
        String newFileName = null; // Иннициализация переменной
        WriteFile writeFile = new WriteFile(); // Создается объект класса WriteFile

        HashMap<String, Object> data = parsData.parsInputData(); // Иннициализация словаря
        while (data.size() != 6) {
            try {
                throw new DataException();
            } catch (DataException e) {
                data = parsData.parsInputData();
            }
        } // Цикл для ввода данных, пока пользователь не введет корректные данные

        newFileName = data.get("lastName") + ".txt"; // Указывается файл для записи данных пользователя
        StringBuilder sb = new StringBuilder();
        for (String str : data.keySet()) {
            sb.append(data.get(str));
            sb.append(" ");
        }


        System.out.println(data);
        String filePath = newFileName;
        System.out.println(filePath);
        writeFile.writeData(String.valueOf(sb), filePath); // Вызывается метод класса WriteFile для записи в файл

    }
}