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
                {Arrays.asList(3),3},
                {Arrays.asList(2,2),4},
                {Arrays.asList(5),5},
                {Arrays.asList(2,3),6},
                {Arrays.asList(7),7},
                {Arrays.asList(2,2,2),8},
                {Arrays.asList(3,3),9},
                {Arrays.asList(2,5),10},
                {Arrays.asList(11),11},
                {Arrays.asList(2,2,3),12},
                {Arrays.asList(13),13},
                {Arrays.asList(2,7),14},
                {Arrays.asList(3,3,11),99},
                {Arrays.asList(5,5),25},
                {Arrays.asList(3,3,3,11,17,29),3*3*3*11*17*29},
                {Arrays.asList(2,3,3,5,7,19,23,29),2*3*3*5*7*19*23*29}
                });
    }

    @Test
    public  void testPrimeFactor(){
        Assert.assertEquals(this.result,PrimeFactor.factor(this.number));
    }
}
