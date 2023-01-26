import java.util.Optional;

public class NonExistentDefaultValue {

    final static String STATUS = "Поле пустое!";
    public static void main(String[] args) {
        NonExistentDefaultValue nonExistentDefaultValue = new NonExistentDefaultValue();

        // Важное отличие между методами orElse() и orElseGet(), в первом случае метод будет вызываться
        // в любом случае, что чревато потерей производительности, если логика в методе будет дорого стоить

        nonExistentDefaultValue.printOrElseGet(Optional.of("JAVA"));

        System.out.println("---");

        nonExistentDefaultValue.printOrElse(Optional.of("JAVA"));
    }

    private String get() {
        System.out.println("Метод get()...");
        return "Поле пустое!";
    }

    private void printOrElseGet(Optional<String> optional) {
        System.out.println(optional.orElseGet(this::get));
    }

    public void printOrElse(Optional<String> optional) {
        System.out.println(optional.orElse(get()));
    }
}