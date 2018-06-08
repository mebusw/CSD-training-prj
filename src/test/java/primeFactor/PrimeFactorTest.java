package primeFactor;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class PrimeFactorTest {

    private List result;
    private int number;

    public PrimeFactorTest(List result, int number){
        this.result = result;
        this.number = number;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> getAllCases() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(2),2},
                {Arrays.asList(3),3}
                });
    }

    @Test
    public  void testPrimeFactor(){
//        Assert.assertEquals(Arrays.asList(2),PrimeFactor.factor(2));
        Assert.assertEquals(this.result,PrimeFactor.factor(this.number));
//        Assert.assertEquals(Arrays.asList(3),PrimeFactor.factor(3));
    }
}
