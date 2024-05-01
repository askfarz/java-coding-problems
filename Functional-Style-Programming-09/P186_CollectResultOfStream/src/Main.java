import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Movie> list = Arrays.asList(
                new Movie("Аватар", 9.5), new Movie("Гарри Поттер", 10),
                new Movie("Человек-Паук", 8.7), new Movie("Форсаж", 7.0),
                new Movie("Форсаж", 8.0), new Movie("Елки", 5.8),
                new Movie("Властелин колец", 8.5), new Movie("Человек-Паук", 8.7));

        // toList, Collectors.toList(), Collectors.toCollection()
        List<Movie> movieList = list.stream()
                .filter(movie -> movie.rating() > 8.0)
                .collect(Collectors.toCollection(ArrayList::new));
        movieList.forEach(System.out::println);

        System.out.println("---------------------------------------");

        // toSet, Collectors.toCollection()
        Set<Movie> movieSet = list.stream()
                .filter(movie -> movie.rating() > 8.0).collect(Collectors.toSet());
        movieSet.forEach(System.out::println);

        System.out.println("---------------------------------------");

        // Collectors.toMap()
        Map<String, Double> movieMap = list.stream()
                .filter(movie -> movie.rating() > 8.0)
                .distinct()
                .collect(Collectors.toMap(Movie::name, Movie::rating));
        movieMap.forEach((k, v) -> System.out.println(k + " " + v));

        System.out.println("---------------------------------------");

        // Частота слов
        String str = "Java Programming Language " +
                "Java Script Programming Language " +
                "Python Programming Language";

        Map<String, Integer> result = Stream.of(str)
                .map(s -> s.split("\\s"))
                .flatMap(Arrays::stream)
                .collect(Collectors.toMap(String::toUpperCase, ints -> 1, Integer::sum));
        result.forEach((k, v) -> System.out.println(k + " " + v));
    }
}