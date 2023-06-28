package Seminar05;

import java.util.*;

public class HW1 {
    public static void main(String[] args) {
        String userString = "Россия идет вперед всей планеты. Планета — это не Россия.";

        Map<String, Integer> stringMap = new HashMap<>();
        String[] words = userString.toLowerCase().split(" ");

        Scanner sc = new Scanner(System.in);
        String wanted = sc.nextLine();
        stringMap.putIfAbsent(wanted, 0);

        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[.,!?;:]", "");
            if (words[i].equals(wanted)) {
                stringMap.put(wanted, stringMap.get(wanted) + 1);
            }
        }

        System.out.println("stringMap = " + stringMap);
    }
}
