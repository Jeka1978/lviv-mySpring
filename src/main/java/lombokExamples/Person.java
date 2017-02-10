package lombokExamples;

import lombok.*;

import java.util.List;

/**
 * Created by Evegeny on 10/02/2017.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Person {
    @Getter
    private String name;
    private int salary;
    private int age;
    @Singular
    private List<String> beers;
    @Singular("oneFish")
    private List<String> fish;


}
