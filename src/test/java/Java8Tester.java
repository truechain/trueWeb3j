import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Java8Tester {
    public static void main(String args[]) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        System.out.println("列表: " +strings);
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        List<Integer> squaresList = numbers.stream().map(i ->i*i).distinct().collect(Collectors.toList());
        System.out.println("Squares List: " + squaresList);
    }
}
