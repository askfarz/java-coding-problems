import java.util.*;
import java.util.stream.Collectors;

public class Partitioning {
    public static void main(String[] args) {
        List<Movie> list = Arrays.asList(
                new Movie("Аватар", 9.5, "Фэнтези"),
                new Movie("Гарри Поттер", 10, "Боевик"),
                new Movie("Человек-Паук", 8.7, "Фэнтези"),
                new Movie("Форсаж", 7.0, "Триллер"),
                new Movie("Форсаж", 8.0, "Триллер"),
                new Movie("", 8.0, "Триллер"),
                new Movie("Елки", 5.8, "Комедия"),
                new Movie("Властелин колец", 8.5, "Приключения"),
                new Movie("Человек-Паук", 8.7, "Фэнтези"));

        System.out.println("partitionByRating(): " + partitionByRating(list));
        System.out.println("partitionByGenre(): " + partitionByGenre(list));
        System.out.println("partitionByGenreToSet(): " + partitionByGenreToSet(list));
        System.out.println("partitionByRatingMax(): " + partitionByRatingMax(list));
    }

    // Важное отличие от метода distinct() в том, что в этом случае у нас сохраняются данные,
    // которые не прошли фильтр
    private static Map<Boolean, List<Movie>> partitionByRating(List<Movie> list) {
        return list.stream()
                .collect(Collectors.partitioningBy(movie -> movie.rating() > 8));
    }

    private static Map<Boolean, List<Movie>> partitionByGenre(List<Movie> list) {
        return list.stream()
                .collect(Collectors.partitioningBy(movie -> movie.genre().equals("Фэнтези")));
    }

    private static Map<Boolean, Set<Movie>> partitionByGenreToSet(List<Movie> list) {
        return list.stream()
                .collect(Collectors.partitioningBy(movie -> !movie.name().isEmpty(), Collectors.toSet()));
    }

    private static Map<Boolean, Movie> partitionByRatingMax(List<Movie> list) {
        return list.stream()
                .collect(Collectors.partitioningBy(movie -> movie.rating() > 8,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Movie::rating)), Optional::get)));
    }
}