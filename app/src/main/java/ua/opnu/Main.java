package ua.opnu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // ========== ЗАВДАННЯ 1: MyOptional<T> ==========
        System.out.println("\n=== ЗАВДАННЯ 1: MyOptional<T> ===\n");

        MyOptional<String> middleName = new MyOptional<>();
        System.out.println("Порожній:");
        System.out.println(middleName);
        System.out.println("isPresent: " + middleName.isPresent());
        System.out.println("isEmpty: " + middleName.isEmpty());
        System.out.println("orElse: " + middleName.orElse("немає"));

        System.out.println();

        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println("Заповнений:");
        System.out.println(username);
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("isEmpty: " + username.isEmpty());
        System.out.println("get(): " + username.get());
        System.out.println("orElse: " + username.orElse("guest"));

        System.out.println();

        // ========== ЗАВДАННЯ 2: BookData (Comparable) ==========
        System.out.println("\n=== ЗАВДАННЯ 2: BookData (Comparable) ===\n");

        List<BookData> books = Arrays.asList(
                new BookData("Майстер і Маргарита", "Булгаков", 100, 850.0),
                new BookData("1984", "Оруелл", 80, 720.0),
                new BookData("Три товариші", "Ремарк", 60, 540.0),
                new BookData("Собор Паризької Богоматері", "Гюго", 40, 340.0),
                new BookData("Злочин і кара", "Достоєвський", 120, 1020.0)
        );

        System.out.println("=== До сортування ===");
        books.forEach(System.out::println);

        Collections.sort(books);

        System.out.println("\n=== Після сортування (від вищого рейтингу до нижчого) ===");
        books.forEach(System.out::println);

        // ========== ЗАВДАННЯ 3: Узагальнений printArray ==========
        System.out.println("\n=== ЗАВДАННЯ 3: Узагальнений printArray ===\n");

        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};

        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        // ========== ЗАВДАННЯ 4: Узагальнений filter ==========
        System.out.println("\n=== ЗАВДАННЯ 4: Узагальнений filter ===\n");

        // Тест з рядками
        String[] words = {"яблуко", "банан", "кіт", "собака", "ананас", "сонце"};
        Predicate<String> lengthFilter = s -> s.length() > 4;

        String[] longWords = filter(words, lengthFilter);
        System.out.println("Слова довші за 4 символи:");
        System.out.println(Arrays.toString(longWords));

        // Тест з числами
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Predicate<Integer> evenFilter = n -> n % 2 == 0;

        Integer[] evenNumbers = filter(numbers, evenFilter);
        System.out.println("\nПарні числа:");
        System.out.println(Arrays.toString(evenNumbers));

        // ========== ЗАВДАННЯ 5: Узагальнений contains ==========
        System.out.println("\n=== ЗАВДАННЯ 5: Узагальнений contains ===\n");

        // Тест з рядками
        String[] names = {"Іван", "Марія", "Петро", "Олена"};
        System.out.println("Містить 'Петро'? " + containsElement(names, "Петро"));
        System.out.println("Містить 'Андрій'? " + containsElement(names, "Андрій"));

        // Тест з числами
        Integer[] numArray = {10, 20, 30, 40, 50};
        System.out.println("Містить 30? " + containsElement(numArray, 30));
        System.out.println("Містить 99? " + containsElement(numArray, 99));

        // Тест з підкласом (Integer)
        Integer[] numObjects = {10, 20, 30, 40, 50};
        System.out.println("Містить 30 (Integer)? " + containsElement(numObjects, 30));

        // ========== ЗАВДАННЯ 6: Узагальнені кортежі ==========
        System.out.println("\n=== ЗАВДАННЯ 6: Узагальнені кортежі (Tuples) ===\n");

        // Приклад 1: Студент + оцінка
        GenericTwoTuple<String, Integer> studentRating =
                new GenericTwoTuple<>("Іванов Петро", 95);
        System.out.println("Студент і оцінка: " + studentRating);

        // Приклад 2: Назва книги + автор + рік
        GenericThreeTuple<String, String, Integer> bookInfo =
                new GenericThreeTuple<>("Майстер і Маргарита", "Булгаков", 1967);
        System.out.println("Книга: " + bookInfo);

        // Приклад 3: Координати точки (x, y)
        GenericTwoTuple<Double, Double> point =
                new GenericTwoTuple<>(3.5, 7.2);
        System.out.println("Координати точки: " + point);

        // Приклад 4: Інформація про товар (назва, ціна, кількість)
        GenericThreeTuple<String, Double, Integer> product =
                new GenericThreeTuple<>("Ноутбук", 24999.99, 5);
        System.out.println("Товар: " + product);

        // Приклад 5: Результат пошуку (знайдено, індекс, значення)
        GenericThreeTuple<Boolean, Integer, String> searchResult =
                new GenericThreeTuple<>(true, 42, "важливі дані");
        System.out.println("Результат пошуку: " + searchResult);

        // Приклад 6: Використання з об'єктами класів з попередніх завдань
        if (books.size() > 0) {
            BookData firstBook = books.get(0);
            MyOptional<String> optionalName = new MyOptional<>("Тест");
            GenericTwoTuple<BookData, MyOptional<String>> complexTuple =
                    new GenericTwoTuple<>(firstBook, optionalName);
            System.out.println("Складний кортеж: " + complexTuple);
        }
    }

    // ========== МЕТОДИ ==========

    // Завдання 4: Узагальнений filter
    public static <T> T[] filter(T[] input, Predicate<T> predicate) {
        ArrayList<T> list = new ArrayList<>();

        for (T element : input) {
            if (predicate.test(element)) {
                list.add(element);
            }
        }

        return list.toArray(Arrays.copyOf(input, 0));
    }

    // Завдання 5: Узагальнений contains
    public static <T extends Comparable<T>, V extends T> boolean containsElement(T[] array, V element) {
        for (T item : array) {
            if (item.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }
}

// ========== ДОПОМІЖНІ КЛАСИ ==========

// Клас для завдання 3
class Printer {
    public <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}

// Клас для завдання 6: GenericTwoTuple
class GenericTwoTuple<T, V> {
    public final T first;
    public final V second;

    public GenericTwoTuple(T first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

// Клас для завдання 6: GenericThreeTuple
class GenericThreeTuple<T, V, S> {
    public final T first;
    public final V second;
    public final S third;

    public GenericThreeTuple(T first, V second, S third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }
}