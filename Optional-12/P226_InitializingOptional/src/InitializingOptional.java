import java.util.Optional;

public class InitializingOptional {
    public static void main(String[] args) {
        // Правильная инициализация

        // Если мы уверены, что объект не null, в противном случае при работе может выкинуться NPE
        Optional<String> str = Optional.of("Java");

        // Допускается инициализация null, не выкидывается NPE
        Optional<String> strNull = Optional.ofNullable(null);

        // Инициализация пустого Optional
        Optional<String> strEmpty = Optional.empty();
    }
}