package com.company;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Laba13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        Pattern pattern = Pattern.compile("(((\\d|\\d\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.){3})(25[0-5]|2[0-4]\\d|1\\d\\d|\\d\\d|\\d)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            // объект класса BufferedWriter для записи результата в файл
            // конструкция try-with-resources для автоматического закрытия потока
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("ip-addresses.txt"))) {
                // записываем найденный IP-адрес в файл
                bw.write(matcher.group());
            } catch (IOException e) {
                // сообщение об ошибке при записи
                System.out.println("Ошибка");
            }
        } else {
            System.out.println("Не выявлено совпадение");
        }
    }
}