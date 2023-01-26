import java.util.Optional;

public class AlreadyConstructedDefaultValue {

    final static String STATUS = "Поле пустое!";

    public static void main(String[] args) {
        print(Optional.empty());
        print(Optional.of("JAVA"));
    }

    public static void print(Optional<String> optional) {
        System.out.println(optional.orElse(STATUS));
    }
}