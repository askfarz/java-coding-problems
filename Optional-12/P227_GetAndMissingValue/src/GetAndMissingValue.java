import java.util.Optional;

public class GetAndMissingValue {
    public static void main(String[] args) {
        Optional<String> str = Optional.of("java");
        Optional<String> strOrNull = Optional.ofNullable(null);

        // При использовании метода get() необходимо проводить проверку isPresent(), иначе можем поймать NPE
        if (strOrNull.isPresent()) {
            System.out.println(strOrNull.get());
        } else if (str.isPresent()) {
            System.out.println(str.get());
        }
    }
}