public class EmptyOptionalObjectException extends Throwable {
    @Override
    public String getMessage() {
        return "Объект пустой!";
    }
}
