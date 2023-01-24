import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SearchElement {
    public static void main(String[] args) {
        List<Car> listCars = Arrays.asList(
                new Car("Ford", 23_000),
                new Car("Tesla", 100_000),
                new Car("Ford", 70_000),
                new Car("Ferrari", 150_000),
                new Car("Ferrari", 200_000));

        System.out.println("findAny: " + findAny(listCars));
        System.out.println("findFirst: " + findFirst(listCars));
    }

    public static Car findAny(List<Car> list) {
        return list.parallelStream().findAny().orElse(new Car());
    }

    public static Car findFirst(List<Car> list) {
        return list.parallelStream()
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(new Car());
    }


    public static class Car {
        private String model;
        private int price;

        public Car(String model, int price) {
            this.model = model;
            this.price = price;
        }

        public Car() {
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }


        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "model='" + model + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}