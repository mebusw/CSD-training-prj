package primeFactor;


import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class PrimeFactorTest {

    @Test
    public  void testPrimeFactor(){
        Assert.assertEquals(Arrays.asList(2),PrimeFactor.factor(2));
        Assert.assertEquals(Arrays.asList(3),PrimeFactor.factor(3));
    }
}
