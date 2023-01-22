import java.util.Arrays;
import java.util.List;
import java.util.Objects;
public class FilterNonZeroElement {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 6, 7, 8, 0, 1, 0, -1, 0, 0, 4);

        System.out.println(filter(list));
        System.out.println(filterMethodLink(list));
    }

    public static List<Integer> filter(List<Integer> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .filter(x -> x != 0)
                .toList();
    }

    public static List<Integer> filterMethodLink(List<Integer> list) {
        return list.stream()
                .filter(FilterNonZeroElement::checkNonNullAndNonZero)
                .toList();
    }

    public static boolean checkNonNullAndNonZero(Integer x) {
        return x != null && x != 0;
    }
}