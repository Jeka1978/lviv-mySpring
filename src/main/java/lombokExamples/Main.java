package lombokExamples;

/**
 * Created by Evegeny on 10/02/2017.
 */
public class Main {
    public static void main(String[] args) {

        Person tolik = Person.builder().name("Tolik").age(27).salary(20).beer("Leff").beer("Lvovskoe").build();
    }
}
