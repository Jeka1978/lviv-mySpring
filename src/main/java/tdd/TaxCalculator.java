package tdd;

import lombok.Setter;
import mySpring.InjectByType;
import mySpring.ObjectFactory;

/**
 * Created by Evegeny on 11/02/2017.
 */

public class TaxCalculator {

    public double afterPDV(double price) {
        double pdv = PDVResolverSingleton.getInstance().getPDV();
        return price * pdv/100 + price;
    }


}
