import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Movie> list = Arrays.asList(
                new Movie("Аватар", 9.5), new Movie("Гарри Поттер", 10),
                new Movie("Человек-Паук", 8.7), new Movie("Форсаж", 7.0),
                new Movie("Форсаж", 8.0), new Movie("Елки", 5.8),
                new Movie("Властелин колец", 8.5), new Movie("Человек-Паук", 8.7));

        String nameAllMovie = list.stream().
                map(Movie::name)
                .sorted()
                .distinct()
                .collect(Collectors.joining(", ", "Перечень всех фильмов: ", " "));
        System.out.println(nameAllMovie);
    }
}