package fizzBuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
/*
*Write a program that prints the numbers from 1 to 100.
*But for multiples of three print "Fizz" instead of the
*number and for the multiples of five print "Buzz". For
*numbers which are multiples of both three and five
*print "FizzBuzz".
* */
public class FizzBuzzTest {

    @Test
    public void testFirstNumberEquals1() {
        assertEquals("1", FizzBuzz.answer(1));
    }

    @Test
    public void testThirdNumberEqualsFizz() {
        assertEquals("Fizz", FizzBuzz.answer(3));
    }

    @Test
    public void testFifthNumberEqualsBuzz() {
        assertEquals("Buzz", FizzBuzz.answer(5));
    }

    @Test
    public void testFifteenthNumberFizzBuzz() {
        assertEquals("FizzBuzz", FizzBuzz.answer(15));
    }
    @Test
    public void testOutputForNumbersUpTo3() {
        assertEquals("1\n2\nFizz\n", FizzBuzz.showOutput(1, 3));
    }

    @Test
    public void testOutputForNumbersUpTo5() {
        assertEquals("1\n2\nFizz\n4\nBuzz\n", FizzBuzz.showOutput(1, 5));
    }
    @Test
    public void testOutputForNumbersUpTo10() {
        assertEquals("1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz\n", FizzBuzz.showOutput(1, 10));
    }

    @Test
    public void testOutputForNumbersUpTo15() {
        assertEquals("1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz\n11\nFizz\n13\n14\nFizzBuzz\n", FizzBuzz.showOutput(1, 15));
    }
}
