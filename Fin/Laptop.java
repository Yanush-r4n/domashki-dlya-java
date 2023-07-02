package Fin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Laptop {
    private String brand;
    private String type;
    private String model;
    private Double diagonal;
    private String resolution;
    private Integer refreshRate;
    private String processor;
    private Integer ram;
    private Integer ssd;
    private String videoCard;
    private String os;
    private String color;

    @Override
    public String toString() {
        return String.format("Brand: %s | Type: %s | Model: %s\n" +
                        "Diagonal: %.1f\" | Resolution: %s | Refresh rate: %d Hz \n" +
                        "Processor: %s | RAM: %d Gb| SSD: %d Gb\n" +
                        "Video Card: %s | OS: %s | Color: %s",
                brand, type, model, diagonal, resolution, refreshRate,
                processor, ram, ssd, videoCard, os, color);
    }

    public static Map<String, Set<Object>> allCharacteristics(Set<Laptop> laptops) {
        Map<String, Set<Object>> allCharacteristics = new HashMap<>();

        Class<? extends Laptop> laptopClass = Laptop.class;
        Field[] fields = laptopClass.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Set<Object> fieldValues = new HashSet<>();

            if (fieldName.equals("model")) {
                continue;
            }

            for (Laptop laptop : laptops) {
                try {
                    Object value = field.get(laptop);
                    fieldValues.add(value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            allCharacteristics.put(fieldName, fieldValues);
        }

        return allCharacteristics;
    }

    public static Map<String, Set<Object>> filterByKeys(Map<String, Set<Object>> allCharacteristics) {
        Set<String> filterByKeys = new HashSet<>(allCharacteristics.keySet());

        Scanner sc = new Scanner(System.in);

        System.out.println(
                "Выберите, по каким характеристикам хотите выбрать себе ноут, " +
                        "а когда закончите, напишите [stop]:");

        int number = 1;
        for (String key : filterByKeys) {
            System.out.printf("[%d]:\t%s\n", number, key);
            number++;
        }

        Set<Integer> choices = new HashSet<>();
        String userInput = sc.nextLine().toLowerCase();
        while (!userInput.equals("stop")) {
            try {
                int choice = Integer.parseInt(userInput);
                if (choice < 1 || choice > number - 1) {
                    System.out.println("Такой позиции в каталоге нет.");
                } else {
                    choices.add(choice);
                }
            } catch (NumberFormatException e) {
                System.out.println("Вводи позицию или слово [stop].");
            }

            userInput = sc.nextLine();
        }

        Integer[] choicesArray = choices.toArray(new Integer[0]);
        Set<String> choosenFilter = new HashSet<>();
        for (Integer index : choicesArray) {
            index--;
            List<String> keyList = new ArrayList<>(filterByKeys);
            choosenFilter.add(keyList.get(index));
        }

        Set<String> keysToRemove = new HashSet<>();
        for (String key : allCharacteristics.keySet()) {
            if (!choosenFilter.contains(key)) {
                keysToRemove.add(key);
            }
        }

        for (String key : keysToRemove) {
            allCharacteristics.remove(key);
        }

        return allCharacteristics;
    }

    public static Map<String, List<Object>> filterByValues(Map<String, Set<Object>> allCharacteristics) {
        Map<String, Set<Integer>> filterByValues = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        for (String key : allCharacteristics.keySet()) {
            System.out.println("Параметр: " + key);
            Set<Object> values = allCharacteristics.get(key);
            int number = 1;
            for (Object value : values) {
                System.out.printf("\t[%d]:\t%s\n", number, value.toString());
                number++;
            }

            System.out.println(
                    "Выберите, по каким параметрам хотите выбрать себе ноут, " +
                            "а когда закончите, напишите [stop]:");

            Set<Integer> choices = new HashSet<>();
            String userInput = sc.nextLine().toLowerCase();
            while (!userInput.equals("stop")) {
                try {
                    int choice = Integer.parseInt(userInput);
                    if (choice < 1 || choice > number - 1) {
                        System.out.println("Такой позиции в каталоге нет.");
                    } else {
                        choices.add(choice);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Вводи позицию или слово [stop].");
                }

                userInput = sc.nextLine();
            }

            filterByValues.put(key, choices);
        }

        Map<String, List<Object>> filter = new HashMap<>();
        for (String key : filterByValues.keySet()) {
            Set<Integer> values = filterByValues.get(key);
            Integer[] choosenValue = values.toArray(new Integer[0]);
            List<Object> filteredValues = new ArrayList<>();

            for (Integer index : choosenValue) {
                index--;
                List<Object> valueList = new ArrayList<>(allCharacteristics.get(key));
                filteredValues.add(valueList.get(index));
            }

            filter.put(key, filteredValues);
        }

        return filter;
    }

    public static Object getValueForKey(Laptop laptop, String key) {
        try {
            java.lang.reflect.Field field = Laptop.class.getDeclaredField(key);
            field.setAccessible(true);
            return field.get(laptop);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean filterMatches(Laptop laptop, Map<String, List<Object>> filter) {
        for (String key : filter.keySet()) {
            List<Object> filterValues = filter.get(key);
            Object laptopValue = getValueForKey(laptop, key);

            if (!filterValues.contains(laptopValue)) {
                return false;
            }
        }

        return true;
    }
}
