import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {
        // map()
        List<Integer> list = Arrays.asList(4, 6, 7, 8, 0, 1, 0, -1, 0, 0, 4, null);
        mapToString(list);
        System.out.println();

        // map()
        List<Car> listCars = Arrays.asList(
                new Car("Tesla", 100_000),
                new Car("Ford", 70_000),
                new Car("Ferrari", 150_000));
        System.out.println(mapToModel(listCars));

        // flatMap()
        List<List<String>> nameList = Arrays.asList(
                Arrays.asList("Robert", "Greg"),
                Arrays.asList("Greg", "Suzan"),
                Arrays.asList("Garri", "Robert")
        );
        flatMap(nameList);
    }

    public static void mapToString(List<Integer> ints) {
        ints.stream()
                .filter(Objects::nonNull)
                .map(String::valueOf)
                .map(str -> "№" + str + " ")
                .forEach(System.out::print);
    }

    public static List<String> mapToModel(List<Car> cars) {
        return cars.stream().map(Car::getModel).collect(Collectors.toList());
    }

    public static void flatMap(List<List<String>> names) {
        names.stream().flatMap(Collection::stream)
                .distinct()
                .forEach(System.out::println);

    }

    public static class Car {
        private String model;
        private int price;

        public Car(String model, int price) {
            this.model = model;
            this.price = price;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}