package tdd;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by Evegeny on 11/02/2017.
 */
public class TaxCalculatorTest {
    @Test
    public void afterPDV() throws Exception {
        TaxCalculator taxCalculator = new TaxCalculator();
        PDVResolver pdvResolver = Mockito.mock(PDVResolver.class);
        Mockito.when(pdvResolver.getPDV()).thenReturn(20.0);
        Assert.assertEquals(120,taxCalculator.afterPDV(100),0.0001);
    }

}