import java.util.*;
import java.util.stream.Collectors;

public class SummarizationCollectors {
    public static void main(String[] args) {
        List<Movie> list = Arrays.asList(
                new Movie("Аватар", 9.5, "Фэнтези"),
                new Movie("Гарри Поттер", 10, "Боевик"),
                new Movie("Человек-Паук", 8.7, "Фэнтези"),
                new Movie("Форсаж", 7.0, "Триллер"),
                new Movie("Форсаж", 8.0, "Триллер"),
                new Movie("Елки", 5.8, "Комедия"),
                new Movie("Властелин колец", 8.5, "Приключения"),
                new Movie("Человек-Паук", 8.7, "Боевик"));

        System.out.println("Sum: " + sum(list));
        System.out.println("Average: " + average(list));
        System.out.println("Max: " + max(list));
        System.out.println("Min: " + min(list));
        System.out.println("Count: " + count(list));
        System.out.println("All data: " + allData(list));
    }

    // Сумма рейтинга всех фильмов их списка
    private static double sum(List<Movie> list) {
        return list.stream()
                .collect(Collectors.summingDouble(Movie::rating));
    }

    // Средняя рейтинга всех фильмов их списка
    private static double average(List<Movie> list) {
        return list.stream()
                .collect(Collectors.averagingDouble(Movie::rating));
    }

    // Максимальный рейтинг
    private static Movie max(List<Movie> list) {
        return list.stream()
                .collect(Collectors.maxBy(Comparator.comparing(Movie::rating)))
                .orElseThrow();
    }

    // Минимальный рейтинг
    private static Movie min(List<Movie> list) {
        return list.stream()
                .collect(Collectors.minBy(Comparator.comparing(Movie::rating)))
                .orElseThrow();
    }

    // Посчитать сколько фильмов имеют рейтинг больше 7.5 -> 6
    private static long count(List<Movie> list) {
        return list.stream()
                .map(Movie::rating)
                .filter(rating -> rating > 7.5)
                .collect(Collectors.counting());
    }

    // Sum, average, count, min, max одной операцией
    private static DoubleSummaryStatistics allData(List<Movie> list) {
        return list.stream()
                .collect(Collectors.summarizingDouble(Movie::rating));
    }
}