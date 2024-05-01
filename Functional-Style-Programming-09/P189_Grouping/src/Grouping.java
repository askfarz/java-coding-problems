import java.util.Arrays;
import java.util.List;

public class Grouping {
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
    }

    // Группировать фильмы по жанрам и положить в Map<String, List<Movie>>

}