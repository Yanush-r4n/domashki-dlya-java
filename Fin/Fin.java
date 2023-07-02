package Fin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Fin {
    public static void main(String[] args) {
        Set<Laptop> laptops = laptopsReader();
        Map<String, Set<Object>> allCharacteristics = Laptop.allCharacteristics(laptops);
        Laptop.filterByKeys(allCharacteristics);
        Map<String, List<Object>> filter = Laptop.filterByValues(allCharacteristics);
        List<Laptop> filteredLaptops = filterLaptops(laptops, filter);

        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
            System.out.println("----------------------------------------------------------------------------------");
        }
    }

    private static Set<Laptop> laptopsReader() {
        Set<Laptop> laptops = new HashSet<>();
        try {
            File file = new File("D:\\Projects\\JAVA_API\\src\\main\\java\\Fin\\laptops.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String brand = scanner.nextLine();
                String type = scanner.nextLine();
                String model = scanner.nextLine();
                Double diagonal = Double.parseDouble(scanner.nextLine());
                String resolution = scanner.nextLine();
                Integer refreshRate = Integer.parseInt(scanner.nextLine());
                String processor = scanner.nextLine();
                Integer ram = Integer.parseInt(scanner.nextLine());
                Integer ssd = Integer.parseInt(scanner.nextLine());
                String videoCard = scanner.nextLine();
                String os = scanner.nextLine();
                String color = scanner.nextLine();

                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }

                Laptop laptop = new Laptop(
                        brand, type, model, diagonal, resolution, refreshRate, processor,
                        ram, ssd, videoCard, os, color
                );
                laptops.add(laptop);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            e.printStackTrace();
        }

        return laptops;
    }

    public static List<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, List<Object>> filter) {
        List<Laptop> filteredLaptops = new ArrayList<>();

        // Проходим по каждому ноуту и сравниваем его значения с фильтром
        for (Laptop laptop : laptops) {
            if (Laptop.filterMatches(laptop, filter)) {
                filteredLaptops.add(laptop);
            }
        }

        return filteredLaptops;
    }
}
