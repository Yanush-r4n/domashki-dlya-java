package Seminar02;

import java.util.Arrays;
import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        int[] array = ArrayCreator1D();

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 10 && array[i] <= 99) {
                sum += i;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array [i] = sum;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    public static int[] ArrayCreator1D() {
        System.out.print("Какого размера будет массив? - ");

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.printf("Введи число №%d - ", i + 1);
            numbers[i] = sc.nextInt();
        }

        return numbers;
    }
}
