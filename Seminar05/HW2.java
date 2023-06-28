package Seminar05;

import java.util.*;

public class HW2 {
    public static void main(String[] args) {
        String[] names = {
                "Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин",
                "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"
        };
        Map<String, Integer> mentions = new TreeMap<>();

        for (String s : names) {
            String[] name = s.split(" ");
            mentions.putIfAbsent(name[0], 0);
            mentions.put(name[0], mentions.get(name[0]) + 1);
        }
        names = null;

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(mentions.entrySet());
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        System.out.println("mentions = " + mentions);
        System.out.println("entries = " + entries);
    }
}
