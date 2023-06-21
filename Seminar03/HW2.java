package Seminar03;

import java.util.*;

public class HW2 {
    public static void main(String[] args) {
        Goods plums = new Goods("Сливы", "Россия", 1000, 5.32, "I");
        Goods milk = new Goods("Молоко", "Беларусь", 800, 1.89, "II");
        Goods icecream = new Goods("Мороженое. Высший сорт", "Беларусь", 80, 1.45, "II");
        Goods fruitice = new Goods("Фруктовый лед", "Беларусь", 80, 1.45, "II");
        Goods raspberry = new Goods("Малина. Высший сорт", "Украина", 1000, 5.08, "II");
        Goods cream = new Goods("Сливки", "Латвия", 450, 3.86, "I");
        Goods sausage = new Goods("Колбаса. Высший сорт", "Россия", 500, 2.10, "III");

        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(plums);
        goodsList.add(milk);
        goodsList.add(icecream);
        goodsList.add(fruitice);
        goodsList.add(raspberry);
        goodsList.add(cream);
        goodsList.add(sausage);

        Scanner sc = new Scanner(System.in);
        String targetGrade = sc.nextLine();
        double minPrice = Double.MAX_VALUE;
        List<Goods> lowestPriceGoods = new ArrayList<>();

        for (Goods goods : goodsList) {
            if (goods.getGrade().equals(targetGrade)) {
                double price = goods.getPrice();
                if (price < minPrice) {
                    minPrice = price;
                    lowestPriceGoods.clear();
                    lowestPriceGoods.add(goods);
                } else if (price == minPrice) {
                    lowestPriceGoods.add(goods);
                }
            }
        }

        if (!lowestPriceGoods.isEmpty()) {
            System.out.println("Товары с наименьшей ценой (" + targetGrade + "):");
            for (Goods goods : lowestPriceGoods) {
                System.out.println("Наименование: " + goods.getName() + ", Цена: " + goods.getPrice());
            }
        } else {
            System.out.println("Товары с наименьшей ценой (" + targetGrade + ") не найдены.");
        }
    }
}
