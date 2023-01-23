import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumMinMaxStream {
    public static void main(String[] args) {
        final List<Integer> list = generate(1000);

        System.out.println("Терминальные методы sum(), max(), min(): ");
        System.out.println(list.stream().mapToInt(num -> num).sum());
        System.out.println(list.stream().mapToInt(num -> num).max().orElse(999));
        System.out.println(list.stream().mapToInt(num -> num).min().orElse(-999));

        System.out.println("Терминальный метод reduce(): ");
        System.out.println(list.stream().reduce(0, Integer::sum));
        System.out.println(list.stream().reduce(Math::max).orElse(999));
        System.out.println(list.stream().reduce(Math::min).orElse(-999));
    }

    private static List<Integer> generate(final int size) {
        return IntStream.range(0, size)
                .boxed()
                .map(i -> ThreadLocalRandom.current().nextInt(-100, 100))
                .collect(Collectors.toList());
    }
}