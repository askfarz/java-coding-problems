import java.util.NoSuchElementException;
import java.util.Optional;

public class ThrowingNoSuchElementException {
    public static void main(String[] args) {
        print(Optional.empty());
        printOther(Optional.empty());

    }

    // Если Optional пустой, то выбрасывается исключение NoSuchElementException
    private static void print(Optional<String> optional) {
        try {
            System.out.println(optional.orElseThrow());
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Можно выбрасывать исключения через функц. интерфейс Supplier
    private static void printOther(Optional<String> optional) {
        try {
            System.out.println(optional.orElseThrow(EmptyOptionalObjectException::new));
        } catch (EmptyOptionalObjectException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}