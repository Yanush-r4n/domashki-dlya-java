package Seminar02;

import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
        int[] array = ArrayCreator1D();
        System.out.println(IsIntArrayGrowing(array));
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

    public static boolean IsIntArrayGrowing(int[] numbers) {
        boolean isGrowing = true;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] > numbers[i]) {
                isGrowing = false;
                break;
            }
        }

        return isGrowing;
    }
}
