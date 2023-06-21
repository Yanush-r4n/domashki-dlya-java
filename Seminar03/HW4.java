package Seminar03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HW4 {
    public static void main(String[] args) {
        Integer[] array = {10, 5, 8, 12, 3};

        List<Integer> numbers = new ArrayList<>(Arrays.asList(array));

        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int sum = 0;

        for (int number : numbers) {
            minValue = Math.min(minValue, number);
            maxValue = Math.max(maxValue, number);
            sum += number;
        }

        double average = (double) sum / numbers.size();

        System.out.println("Минимальное значение: " + minValue);
        System.out.println("Максимальное значение: " + maxValue);
        System.out.println("Среднее значение: " + average);
    }
}
