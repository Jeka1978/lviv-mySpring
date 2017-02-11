package java8Examples;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Evegeny on 11/02/2017.
 */
public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("java", "scala", "python", "c#");
        strings.sort((o1, o2) -> o1.length()-o2.length());

        strings.forEach(System.out::println);
    }
}
