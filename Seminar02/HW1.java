package Seminar02;

import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        System.out.print("Какого размера будет массив? - ");

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Введи число №%d - ", i + 1);
            numbers[i] = sc.nextInt();
        }

        int result = SumOfPrimes(numbers);

        if (result == 0) {
            System.out.println("Простых чисел в последовательности нема");
        }
        else {
            System.out.printf("Сумма простых чисел - %d", result);
        }
    }

    /**
     * @apiNote Считает сумму простых чисел в заданной последовательности
     * @param numbers последовательность пользовательских чисел
     * @return Сумму простых чисел
     */
    public static int SumOfPrimes(int[] numbers) {
        int result = 0;
        for (int number : numbers) {
            if (number % 2 == 0 && number != 2 || number <= 1) {
                continue;
            }

            int i = 3;
            boolean isPrime = true;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
                i += 2;
            }

            if (isPrime) {
                result += number;
            }
        }

        return result;
    }
}