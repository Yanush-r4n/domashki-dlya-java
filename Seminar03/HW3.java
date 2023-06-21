package Seminar03;

import java.util.ArrayList;
import java.util.List;

public class HW3 {
    public static void main(String[] args) {
        Library book1 = new Library(
                "Посторонний", "Камю", 1432, 2010, 97);
        Library book2 = new Library(
                "Преступление и наказание", "Достоевский", 1274, 2007, 259);
        Library book3 = new Library
                ("Заводной апельсин", "Бёрджесс", 1349, 2045, 167);
        Library book4 = new Library(
                "Парфюмер", "Зюскинда", 1732, 2012, 211);
        Library book5 = new Library(
                "Коллекционер", "Фаулз", 1627, 2034, 274);

        List<Library> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        List<String> matchingTitles = new ArrayList<>();

        for (Library book : books) {
            int pageCount = book.getPages();
            String authorLastName = book.getAuthorsLastName();
            int yearPublished = book.getYear();

            boolean isPrimePageCount = isPrime(pageCount);
            boolean containsAInLastName = authorLastName.toLowerCase().contains("а");
            boolean isAfter2010 = yearPublished >= 2010;

            if (isPrimePageCount && containsAInLastName && isAfter2010) {
                matchingTitles.add(book.getName());
            }
        }

        if (!matchingTitles.isEmpty()) {
            System.out.println("Названия книг, удовлетворяющие условиям:");
            for (String title : matchingTitles) {
                System.out.println(title);
            }
        } else {
            System.out.println("Книги, удовлетворяющие условиям, не найдены.");
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
