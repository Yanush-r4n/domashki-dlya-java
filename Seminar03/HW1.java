package Seminar03;

import java.util.ArrayList;
import java.util.List;

public class HW1 {
    public static void main(String[] args) {
        Item plums = new Item("Сливы. Высший сорт", 5.32, "I");
        Item milk = new Item("Молоко", 1.89, "II");
        Item icecream = new Item("Мороженое с фисташками. Высший сорт", 1.45, "II");
        Item raspberry = new Item("Малина. Высший сорт", 5.08, "II");
        Item cream = new Item("Сливки", 3.86, "I");
        Item sausage = new Item("Колабса вареная. Высший сорт", 2.10, "III");

        List<Item> itemList = new ArrayList<>();
        itemList.add(plums);
        itemList.add(milk);
        itemList.add(icecream);
        itemList.add(raspberry);
        itemList.add(cream);
        itemList.add(sausage);

        Double maxPrice = 0.00;
        String name = "";
        for (Item item : itemList) {
            if ((item.getGrade().equals("I") ||
                 item.getGrade().equals("II")) &&
                (item.getName().contains("Высший"))) {
                if (item.getPrice() > maxPrice) {
                    maxPrice = item.getPrice();
                    name = item.getName();
                }
            }
        }

        System.out.println(maxPrice);
        System.out.println(name);
    }
}
