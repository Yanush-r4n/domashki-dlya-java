package Seminar04;

import java.util.LinkedList;
import java.util.Random;

public class HW1 {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            numbers.add(random.nextInt(10));
        }
        System.out.println("numbers = " + numbers);

        LinkedList<Integer> reversNumbers = new LinkedList<>();
        while (!numbers.isEmpty()) {
            reversNumbers.addFirst(numbers.removeFirst());
        }
        System.out.println("reversNumbers = " + reversNumbers);
    }
}
