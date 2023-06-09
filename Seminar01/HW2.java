package Seminar01;

import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите последовательность чисел, оканчивающуюся нулём");

        int sum = 0;
        int number = sc.nextInt();
        while (number != 0) {
            int temp = number;
            number = sc.nextInt();
            if (number < 0 && temp > 0) {
                sum += temp;
            }
        }

        System.out.printf("sum = %d", sum);
    }
}