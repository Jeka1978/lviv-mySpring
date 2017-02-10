package mySpring;

import lombok.ToString;

import java.util.Random;

/**
 * Created by Evegeny on 10/02/2017.
 */
@ToString
public class Elf {
    @InjectRandomInt(min = 10, max = 30)
    private int power;
    @InjectRandomInt(min = 100, max = 150)
    private int dexterity;

}
