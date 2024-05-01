import java.util.Arrays;
import java.util.List;

public class MatchElement {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Java", "Python", "C++", "C#", "GO", "Java Script", "Kotlin");

        System.out.println(strings.stream().allMatch(str -> str.startsWith("Java")));   // false
        System.out.println(strings.stream().anyMatch(str -> str.startsWith("Java")));   // true
        System.out.println(strings.stream().noneMatch(str -> str.startsWith("Java")));  // false
    }
}